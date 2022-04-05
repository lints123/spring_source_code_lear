package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lints
 * @Date 2022/3/31
 * @Descirption 注册BeanDefinition
 */
public interface BeanDefinitionRegistry {

    /**
     * 往注册表中新增数据
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 返回当前Bean的定义
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 匹配Bean的定义
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回多个Bean定义的信息
     * @return
     */
    String[] getBeanDefinitionNames();
}
