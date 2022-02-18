package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
