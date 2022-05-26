package com.learn.springframework.beans.factory;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption 实现此接口，既能感知到所属的 ClassLoader
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);

}
