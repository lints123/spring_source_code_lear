package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public interface BeanDefinitionRegistry {

    /**
     * 往注册表中注册
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用BeanName，返回BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    /**
     * 判断是否存在指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中的BeanDefinition
     * @return
     */
    String[] getBeanDefinitionNames();
}
