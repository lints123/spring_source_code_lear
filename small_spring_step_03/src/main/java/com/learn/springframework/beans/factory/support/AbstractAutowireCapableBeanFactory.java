package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try{
            // TODO 存在问题，如果是有参构造方法，怎么处理呢？
            // bean = beanDefinition.getBeanClass().newInstance();
            bean = createBeanDefinition(beanDefinition, beanName, args);
        }catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, beanDefinition);
        return bean;
    }

    protected Object createBeanDefinition(BeanDefinition beanDefinition,String beanName,Object[] args){
        // Constructor代表有多少个构造函数。
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取到所有的构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            // 比对数量是否一致，一致则返回。
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        // 创建的BeanDefinition返回
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
