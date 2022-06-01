package com.learn.springframework.beans.factory.config;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.BeanFactory;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption 定义后置处理器
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    // 执行BeanPostProcess接口实现类的PostProcessBeforeInitialization方法
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    // 执行BeanPostProcess接口实现类的PostProcessAfterInitialization方法
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
