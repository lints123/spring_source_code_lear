package com.learn.springframework.test;

import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learn.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption
 */
public class ApiTest {

    @Test
    public void testBean_Factory(){
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService", "张三");
        userService.queryUserInfo();
    }

}
