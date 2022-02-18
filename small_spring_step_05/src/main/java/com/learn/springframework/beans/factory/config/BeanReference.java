package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption Bean的应用，依赖注入前提条件使用
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
