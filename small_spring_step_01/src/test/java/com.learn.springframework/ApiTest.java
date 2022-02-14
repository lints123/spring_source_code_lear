package com.learn.springframework;

import org.junit.Test;

/**
 * @author lints
 * @Date 2022/2/11
 * @Descirption
 */

public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
