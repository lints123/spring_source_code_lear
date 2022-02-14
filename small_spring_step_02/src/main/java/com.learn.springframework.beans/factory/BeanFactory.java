package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/2/13
 * @Descirption
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
