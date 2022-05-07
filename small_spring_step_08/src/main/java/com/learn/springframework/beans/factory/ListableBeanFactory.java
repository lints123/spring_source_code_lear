package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author lints
 * @Date 2022/4/11
 * @Descirption 暂时不知道什么用处
 */
public interface ListableBeanFactory extends BeanFactory {

    // 根据类型返回Bean实例
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    // 返回Bean的具体定义信息
    String[] getBeanDefinitionNames();

}
