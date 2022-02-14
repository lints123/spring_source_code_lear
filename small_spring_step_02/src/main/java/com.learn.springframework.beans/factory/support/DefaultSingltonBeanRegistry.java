package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lints
 * @Date 2022/2/11
 * @Descirption
 */
public class DefaultSingltonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 缓存单例对象。
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();



    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 保存单例对象
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }

}
