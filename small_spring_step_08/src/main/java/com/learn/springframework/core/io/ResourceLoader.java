package com.learn.springframework.core.io;

/**
 * @author lints
 * @Date 2022/5/5
 * @Descirption
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
