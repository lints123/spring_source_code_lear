package com.learn.springframework.beans.context;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption 上下文的实现
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
