package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption 定义实例化策略类
 */
public interface InstantiationStrategy {

    /**
     * 声明实例化方法
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
