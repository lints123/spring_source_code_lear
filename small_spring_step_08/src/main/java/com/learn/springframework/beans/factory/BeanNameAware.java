package com.learn.springframework.beans.factory;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}
