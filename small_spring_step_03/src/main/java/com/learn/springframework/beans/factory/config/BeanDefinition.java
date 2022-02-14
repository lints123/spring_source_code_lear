package com.learn.springframework.beans.factory.config;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption 封装对象信息使用
 */
public class BeanDefinition {

    private Class BeanClass;

    public BeanDefinition(Class beanClass) {
        BeanClass = beanClass;
    }

    public Class getBeanClass() {
        return BeanClass;
    }

    public void setBeanClass(Class beanClass) {
        BeanClass = beanClass;
    }
}
