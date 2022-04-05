package com.learn.springframework.beans.context.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.lang.ref.PhantomReference;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption 实例化BeanFactory，加载资源文件，实现接口BeanFactoryPostProcesser、BeanPostProcesser
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    /**
     * 1. 主要获取DefailtListableBeanFactory的实例化
     * 2. 资源配置的加载，加载完之后对配置文件中Bean的定义和注册。
     * 3.
     * @throws BeansException
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    // 加载BeanDefinition
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
