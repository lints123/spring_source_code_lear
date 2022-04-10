package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;
import com.learn.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption 不知道怎么形容这个类
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 返回Bean定义
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    // 提前实例化单例对象
    void preInstantiateSingletons() throws BeansException;

    // 添加后置处理器
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
