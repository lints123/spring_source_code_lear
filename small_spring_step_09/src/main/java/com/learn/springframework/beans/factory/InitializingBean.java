package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption 初始化Bean
 */
public interface InitializingBean {

    /**
     * Bean处理了属性填充后调用
     * @throws BeansException
     */
    void afterPropertiesSet() throws BeansException;

}
