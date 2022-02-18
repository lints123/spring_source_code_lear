package com.learn.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.PropertyValues;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanDefinition(beanDefinition, beanName, args);

            // 填充属性和依赖注入
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 保存单例缓存
        addSingleton(beanName, beanDefinition);
        return bean;
    }

    protected Object createBeanDefinition(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor ctorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        // 获取所有的构造函数
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                ctorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, ctorToUse, args);
    }

    /**
     * 属性填充
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
