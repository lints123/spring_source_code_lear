package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption 默认实现注册单例接口
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }
}
