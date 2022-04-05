package com.learn.springframework.test06;

import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.PropertyValues;
import com.learn.springframework.beans.context.support.ClassPathXmlApplicationContext;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanReference;
import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learn.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.learn.springframework.test06.bean.UserDao;
import com.learn.springframework.test06.bean.UserService;
import com.learn.springframework.test06.common.MyBeanFactoryPostProcessor;
import com.learn.springframework.test06.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * @author lints
 * @Date 2022/4/1
 * @Descirption
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 初始化BeanF
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // UserDao注册？？？
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println(result);
    }


    @Test
    public void test_xml_06(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:lear_content.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println(result);

    }


    // 不用应用上下文
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件并且注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:lear_context.xml");

        // 3. BeanDefinition加载完成 & 实例化之前，修改BeanDefinition的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改属性值
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println("测试结果：" + s);
    }

    /**
     * 使用上下文
     */
    @Test
    public void test_context(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:use_context.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println("测试结果：" + s);
    }

}
