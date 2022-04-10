package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.PropertyValues;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption 返回Bean的定义
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    /**
     * 主要用于XML配置文件中使用。
     * 可以配置 init-method="initDataMethod" destroy-method="destroyDataMethod" 操作
     */
    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
