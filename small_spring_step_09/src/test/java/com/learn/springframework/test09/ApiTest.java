package com.learn.springframework.test09;

import cn.hutool.core.bean.BeanUtil;
import com.learn.springframework.beans.context.support.ClassPathXmlApplicationContext;
import com.learn.springframework.test09.bean.ProxyBeanFactory;
import com.learn.springframework.test09.bean.UserService;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

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
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String s = userService.queryUserInfo();
//        System.out.println("测试结果：" + s);
//        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
//        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }

    @Test
    public void test_prototype(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
         System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
