package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册表中注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
