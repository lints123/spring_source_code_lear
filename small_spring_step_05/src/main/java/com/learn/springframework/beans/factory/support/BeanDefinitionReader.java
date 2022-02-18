package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.core.io.Resource;
import com.learn.springframework.core.io.ResourceLoader;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption Bean定义读取接口
 */
public interface BeanDefinitionReader {

    /**
     * 定义的getRegistry和getResourceLoader，都是为了实现
     * @return
     */

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;


}
