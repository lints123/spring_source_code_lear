package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/4/11
 * @Descirption 单例对象注册容器
 */
public interface SingletonBeanRegistery {

    Object getSingleton(String beanName);
}
