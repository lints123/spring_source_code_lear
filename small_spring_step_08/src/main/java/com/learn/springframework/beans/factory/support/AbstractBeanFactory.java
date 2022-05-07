package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;
import com.learn.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.learn.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lints
 * @Date 2022/4/13
 * @Descirption 该类的作用：定义模板方法。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    // 定义后置处理器
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object[] args) throws BeansException {
        return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<?> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    // 定义模板方法
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object singleton = getSingleton(name);
        if (null != singleton) {
            return (T) singleton;
        }
        // 创建BeanDefinition
        BeanDefinition beanDefinition = getBeanDefinition(name);

        // 创建Bean
        return (T) createBean(name, beanDefinition, args);
    }

    // 创建BeanDefinition
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    // 创建Bean
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
