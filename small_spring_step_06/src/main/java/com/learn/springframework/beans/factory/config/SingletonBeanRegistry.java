package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/3/27
 * @Descirption 单例创建Bean对象
 */
public interface SingletonBeanRegistry {

    // 返回单例
    Object getSingleton(String beanName);

}
