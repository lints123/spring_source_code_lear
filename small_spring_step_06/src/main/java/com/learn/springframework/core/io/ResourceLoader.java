package com.learn.springframework.core.io;

/**
 * @author lints
 * @Date 2022/4/1
 * @Descirption 封装统一的资源加载类
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 返回具体的实现类
     * @param location
     * @return
     */
    Resource getResource(String location);
}
