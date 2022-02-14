package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/2/13
 * @Descirption
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass(){
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
