package com.learn.springframework.beans.context.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.context.ApplicationContext;
import com.learn.springframework.beans.context.ApplicationContextAware;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;


    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
