package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.factory.PropertyValue;
import com.learn.springframework.beans.factory.PropertyValues;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption 定义Bean对象的信息
 */
public class BeanDefinition {

    private Class BeanClass;

    // 属性信息
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        BeanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        BeanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return BeanClass;
    }

    public void setBeanClass(Class beanClass) {
        BeanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
