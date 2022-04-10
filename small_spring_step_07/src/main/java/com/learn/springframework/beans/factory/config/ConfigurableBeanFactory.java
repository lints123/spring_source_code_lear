package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption 暂时不知道做什么用处
 * TODO 缺少继承单例
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistery {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
