package com.learn.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lints
 * @Date 2022/2/15
 * @Descirption 主要用于处理资源加载流
 * 定义Resource接口，提供获取InputStream流的方法，子类有ClassPath、FileSystem、URL
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
