package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
