package com.learn.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lints
 * @Date 2022/2/11
 * @Descirption 包含Bean的注册，注册的是Bean的定义信息，并且获取Bean。
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(16);

    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition){
        beanDefinitionMap.put(beanName, beanDefinition);
    }

}
