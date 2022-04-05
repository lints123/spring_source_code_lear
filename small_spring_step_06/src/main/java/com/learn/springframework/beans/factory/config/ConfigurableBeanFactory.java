package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
