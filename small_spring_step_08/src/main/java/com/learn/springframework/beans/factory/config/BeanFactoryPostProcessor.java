package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author lints
 * @Date 2022/5/5
 * @Descirption
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
