package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

import java.beans.Beans;

/**
 * @author lints
 * @Date 2022/3/27
 * @Descirption Bean工厂
 */
public interface BeanFactory {

    // 返回Bean
    Object getBean(String name) throws BeansException;

    // 返回有方法参数的Bean
    Object getBean(String name, Object[] args) throws BeansException;

    // 根据类型获取Bean
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
