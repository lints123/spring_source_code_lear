package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.core.io.Resource;
import com.learn.springframework.core.io.ResourceLoader;

/**
 * @author lints
 * @Date 2022/4/1
 * @Descirption 声明BeanDefinition读取接口
 * 整合BeanDefinition
 */
public interface BeanDefinitionReader {

    /**
     * 返回BeanDefinitionRegistry
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 资源加载
     * @return
     */
    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
