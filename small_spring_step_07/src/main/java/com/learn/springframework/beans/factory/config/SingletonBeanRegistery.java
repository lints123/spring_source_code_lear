package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption
 */
public interface SingletonBeanRegistery {

    // 返回单例
    Object getSingleton(String beanName);

}
