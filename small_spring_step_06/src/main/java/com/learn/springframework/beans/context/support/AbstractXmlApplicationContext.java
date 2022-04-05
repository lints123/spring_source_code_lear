package com.learn.springframework.beans.context.support;

import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learn.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption 配置信息的加载
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    /**
     * 加载Xml配置信息
     * @param beanFactory
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    // 此方法是为了从入口上下文类，拿到配置信息的地址描述
    protected abstract String[] getConfigLocations();
}
