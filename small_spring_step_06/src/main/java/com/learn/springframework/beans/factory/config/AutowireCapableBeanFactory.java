package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.BeanFactory;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption 后置处理
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcess接口实现类的PostProcessBeofreInitialiation方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行BeanPostProcess接口实现类的PostProcessAfterInitialiation方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
