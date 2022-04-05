package com.learn.springframework.core.io;

import com.learn.springframework.beans.BeansException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lints
 * @Date 2022/4/1
 * @Descirption  处理资源加载的流
 * 提供获取InputStream流的方法，子类有ClassPath、FileSystem、URL
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
