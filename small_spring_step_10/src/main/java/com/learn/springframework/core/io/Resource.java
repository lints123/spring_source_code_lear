package com.learn.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
