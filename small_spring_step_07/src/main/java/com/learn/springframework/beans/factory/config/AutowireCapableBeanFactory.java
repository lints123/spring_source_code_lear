package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.BeanFactory;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption 后置处理器
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcess接口实现类的PostProcessBeforeInitialization方法
     * 前置
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;


    /**
     * 执行BeanPostProcess接口实现类的PostProcessAfterInitialization方法
     * 后置
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
