package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String beanName) throws BeansException;

}
