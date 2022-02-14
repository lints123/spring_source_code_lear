package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.BeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;

import java.beans.Beans;

/**
 * @author lints
 * @Date 2022/2/13
 * @Descirption TODO 抽象类定义模板方法
 * 继承了DefaultSingltonBeanRegistery 也就具备了使用单例注册类方法。
 */
public abstract class AbstractBeanFactory extends DefaultSingltonBeanRegistry implements BeanFactory {

    /**
     * 从缓存获取Bean；获取到直接返回，获取不到则再创建。
     * 这里并没有做具体实现，只是通过模板方法定义了调用过程和提供了抽象方法。由实现此抽象类的具体实现类去实现该方法。
     * 那么，继承AbstractBeanFactory的方法有两个：AbstractAutowireCapableBeanFactory、DefaultListableBeanFactory。
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        /**
         * 尝试获取缓存
         * 获取不到则获取对象信息，创建实例对象并且存储到缓存中。
         */
        Object bean = getSingleton(name);
        if (null != bean) {
            System.out.println("缓存返回 >>> ");
            return bean;
        }
        // 获取对象信息
        BeanDefinition beanDefinition = getBeanDefinition(name);

        // 创建实例对象
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
