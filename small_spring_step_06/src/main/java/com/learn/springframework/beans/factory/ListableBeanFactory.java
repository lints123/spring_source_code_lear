package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author lints
 * @Date 2022/3/31
 * @Descirption
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 根据类型返回Bean实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * 返回注册表所有的名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
