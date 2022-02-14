package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption JDK实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try{
            if (null != ctor) {
                // 将入参方式传递进行实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // 如果为空，则表示无参构造函数
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
