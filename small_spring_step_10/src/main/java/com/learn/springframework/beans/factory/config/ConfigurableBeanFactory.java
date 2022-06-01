package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistery {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    // 保存后置处理器实现
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    // 销毁方法
    void destroySingletons();

}
