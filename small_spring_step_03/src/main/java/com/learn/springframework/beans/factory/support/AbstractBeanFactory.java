package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.BeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.support.DefaultSingletonBeanRegistry;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption 模板方法定义实现创建Bean的过程，同时声明抽象方法给其他实现类使用
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, String... args) throws BeansException {
        return doGetBean(name, args);
    }

    /**
     * 定义模板方法
     * @param name
     * @param args
     * @param <T>
     * @return
     */
    protected <T> T doGetBean(final String name,final Object[] args) {
        Object bean = getSingleton(name);
        if (null != bean) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException;
}
