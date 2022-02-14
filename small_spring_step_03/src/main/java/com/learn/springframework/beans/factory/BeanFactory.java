package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption
 */
public interface BeanFactory {

    /**
     * 无参构造，实例化Bean
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 有参构造，实例化Bean
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, String... args) throws BeansException;

}
