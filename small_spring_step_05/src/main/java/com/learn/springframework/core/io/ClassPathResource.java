package com.learn.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.learn.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lints
 * @Date 2022/2/15
 * @Descirption
 */
public class ClassPathResource implements Resource {

    private final String path;

    // 定义类加载器
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    // 获取文件流
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (null == is) {
            throw new FileNotFoundException(this.path + "cannot be opened because is does not exist");
        }
        return is;
    }
}
