package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption 可获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口。
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
