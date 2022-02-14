package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lints
 * @Date 2022/2/13
 * @Descirption
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
