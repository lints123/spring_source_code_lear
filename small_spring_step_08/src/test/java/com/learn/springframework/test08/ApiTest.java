package com.learn.springframework.test08;

import com.learn.springframework.beans.context.support.ClassPathXmlApplicationContext;
import com.learn.springframework.test08.bean.UserService;
import org.junit.Test;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption
 */
public class ApiTest {

    /**
     * 使用上下文
     */
    @Test
    public void test_context(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println("测试结果：" + s);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());

    }


}
