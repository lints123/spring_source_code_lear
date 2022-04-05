package com.learn.springframework.test06.common;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;
import com.learn.springframework.test06.bean.UserService;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
