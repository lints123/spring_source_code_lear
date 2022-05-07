package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.core.io.Resource;
import com.learn.springframework.core.io.ResourceLoader;

/**
 * @author lints
 * @Date 2022/5/5
 * @Descirption
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(String location) throws BeansException;

    void loadBeanDefinition(String... locations) throws BeansException;

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resources) throws BeansException;

}
