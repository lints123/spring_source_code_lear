package com.learn.springframework.core.io;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption  包装资源加载器。集中到统一的类进行管理，外部用户只需要传递资源地址即可
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
