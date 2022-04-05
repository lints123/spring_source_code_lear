package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;
import com.learn.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author lints
 * @Date 2022/3/31
 * @Descirption 提供分析和修改Bean以及预先实例化的操作接口
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    // 返回具体得实例Bean
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    // 提前实例化单例Bean对象
    void preInstantiateSingletons() throws BeansException;

    //
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
