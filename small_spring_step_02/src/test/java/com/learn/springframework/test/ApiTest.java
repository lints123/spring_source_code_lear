package com.learn.springframework.test;

import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learn.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author lints
 * @Date 2022/2/13
 * @Descirption
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 第一次获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserinfo();

        // 第二次获取，从缓存中获取Bean
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserinfo();
    }

}
