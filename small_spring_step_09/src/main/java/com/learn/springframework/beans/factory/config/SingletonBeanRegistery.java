package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption 单例对象注册容器
 */
public interface SingletonBeanRegistery {

    Object getSingleton(String beanName);

}
