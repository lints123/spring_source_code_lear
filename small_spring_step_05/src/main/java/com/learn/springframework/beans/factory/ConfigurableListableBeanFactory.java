package com.learn.springframework.beans.factory;

import cn.hutool.core.bean.BeanException;
import com.learn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption 提供分析和修改Bean以及预先实例化的操作接口
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

}
