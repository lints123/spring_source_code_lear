package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.core.io.Resource;
import com.learn.springframework.core.io.ResourceLoader;


/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption
 */
public interface BeanDefinitionReader {

    // 返回BeanDefinitionRegistry
    BeanDefinitionRegistry getRegistry();

    // 资源加载
    ResourceLoader getResourceLoader();

    // 定义加载的方法名
    void loadBeanDefinition(String location) throws BeansException;

    void loadBeanDefinition(String... locations) throws BeansException;

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resources) throws BeansException;

}
