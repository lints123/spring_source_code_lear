package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.PropertyValues;

/**
 * @author lints
 * @Date 2022/3/27
 * @Descirption  返回Bean的定义
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

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
}
