package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

import java.beans.Beans;

/**
 * @author lints
 * @Date 2022/4/10
 * @Descirption 初始化
 */
public interface InitializingBean {

    /**
     * Bean处理了属性填充后调用
     * @throws BeansException
     */
    void afterPropertiesSet() throws BeansException;

}
