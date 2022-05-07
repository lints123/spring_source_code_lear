package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.PropertyValues;

/**
 * @author lints
 * @Date 2022/4/12
 * @Descirption 定义类的信息
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues ;

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

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
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
