package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.BeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    // 模板方法调用
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object singleton = getSingleton(name);
        if (null != singleton) {
            return (T) singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);

        return (T) createBean(name, beanDefinition, args);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
