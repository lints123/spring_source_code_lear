package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lints
 * @Date 2022/2/13
 * @Descirption TODO 实现对Bean的实例化操作。这里有个问题，如果有构造参数入参的情况怎么处理？
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            // TODO 这里存在如果有构造参数的情况，则无法进行实例化。
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 处理完Bean对象实例化之后，直接调用addSingleton方法存放到单例对象的缓存中去。
        addSingleton(beanName, bean);

        return bean;
    }
}
