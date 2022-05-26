package com.learn.springframework.core.io;


import com.learn.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lints
 * @Date 2022/5/5
 * @Descirption
 */
public class ClassPathResource implements Resource {

    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = null != classLoader ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (null == is) {
            throw new FileNotFoundException(this.path + "cannot be opened because is does not exist");
        }
        return is;
    }
}
