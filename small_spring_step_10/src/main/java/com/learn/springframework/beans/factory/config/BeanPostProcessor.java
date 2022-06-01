package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption 定义后置处理器
 */
public interface BeanPostProcessor {

    // Bean对象执行初始化之前，执行该方法
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    // Bean对象执行初始化之后，执行该方法
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
