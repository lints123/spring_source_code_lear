package com.learn.springframework.core.io;

import com.learn.springframework.beans.BeansException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lints
 * @Date 2022/5/5
 * @Descirption
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
