package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/2/11
 * @Descirption 单例注册接口定义和实现
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

}
