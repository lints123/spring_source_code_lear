package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;
import com.learn.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    // 添加后置处理器
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
