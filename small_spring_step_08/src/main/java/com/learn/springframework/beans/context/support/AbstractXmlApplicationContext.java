package com.learn.springframework.beans.context.support;

import com.learn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learn.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author lints
 * @Date 2022/5/5
 * @Descirption
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinition(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            xmlBeanDefinitionReader.loadBeanDefinition(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
