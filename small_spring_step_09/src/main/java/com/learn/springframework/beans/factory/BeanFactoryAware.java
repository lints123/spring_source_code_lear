package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption 实现此接口，就能感知到所属的 BeanFactory
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
