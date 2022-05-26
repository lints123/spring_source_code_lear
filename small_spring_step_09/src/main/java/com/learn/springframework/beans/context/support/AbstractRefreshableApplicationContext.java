package com.learn.springframework.beans.context.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.learn.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinition(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinition(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
