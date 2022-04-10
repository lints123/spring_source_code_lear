package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption 定义前置处理器
 * 在所有的BeanDefinition加载完成之后，实例化Bean对象前，提供修改BeanDefinition属性的机制
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
