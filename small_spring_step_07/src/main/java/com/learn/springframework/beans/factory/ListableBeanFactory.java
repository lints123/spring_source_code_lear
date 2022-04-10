package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author lints
 * @Date 2022/4/7
 * @Descirption 简单BeanFactory, 封装Bean的信息
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 根据类型返回Bean实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * 返回Bean的定义信息
     * @return
     */
    String[] getBeanDefinitionNames();
}
