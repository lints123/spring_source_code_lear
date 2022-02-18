package com.learn.springframework.test;

import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.PropertyValues;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanReference;
import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learn.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.learn.springframework.test.bean.UserDao;
import com.learn.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author lints
 * @Date 2022/2/18
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
    public void test_xml(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println(result);

    }

}
