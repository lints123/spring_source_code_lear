package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption 定义后置处理器
 * 实例化Bean之前，对Bean进行处理
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行该方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
