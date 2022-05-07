package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/4/11
 * @Descirption 顶层BeanFactory
 */
public interface BeanFactory {

    // 返回Bean
    Object getBean(String name) throws BeansException;

    // 返回有参数的Bean
    Object getBean(String name, Object[] args) throws BeansException;

    // 根据类型返回Bean
    <T> T getBean(String name, Class<?> requiredType) throws BeansException;

}
