package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption
 */
public interface FactoryBean<T> {

    // 获取对象
    T getObject() throws BeansException;

    // 获取对象类型
    Class<?> getObjectType();

    // 是否是单例对象
    boolean isSingleton();

}
