package com.learn.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.PropertyValues;
import com.learn.springframework.beans.factory.*;
import com.learn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;
import com.learn.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author lints
 * @Date 2022/4/13
 * @Descirption 主要作用：创建Bean对象
 * TODO 上下文、简单BeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubClassInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanDefinition(beanDefinition, beanName, args);

            // 属性注入
            addPropertyValues(beanName, bean, beanDefinition);

            // 执行后置处理器的方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 执行销毁方法
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        // 保存单例
        addSingleton(beanName, bean);

        return bean;
    }

    protected Object createBeanDefinition(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor ctorToUse = null;
        Class beanClass = beanDefinition.getClass();
        // 获取所有的构造函数
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                ctorToUse = ctor;
                break;
            }
        }
        // 反射构造BeanDefinition
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, ctorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    protected void addPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 设置值
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    // 初始化Bean
    protected Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // invokeAwareMethods
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware) {
                ((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }


        // 执行后置处理器。方法前
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        // 执行初始化方法
        try {
            invokeInitMethods(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }
        // 执行后置处理器，方法后
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);

        return wrappedBean;
    }

    // 执行初始化方法
    protected void invokeInitMethods(String beanName,Object wrappedBean,BeanDefinition beanDefinition) throws Exception {
        // 1. 实现接口InitializingBean
        if (wrappedBean instanceof InitializingBean) {
            ((InitializingBean) wrappedBean).afterPropertiesSet();
        }

        // 2. 配置信息init-method
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)) {
            // 执行初始化方法
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            // 执行该方法
            initMethod.invoke(wrappedBean);
        }

    }

    // 前置方法
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(existingBean, beanName);
            if (null == current) {
                return current;
            }
            result = current;
        }
        return result;
    }

    // 后置方法
    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(existingBean, beanName);
            if (null == current) {
                return current;
            }
            result = current;
        }
        return result;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 存在则执行
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            // 注册
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }
}
