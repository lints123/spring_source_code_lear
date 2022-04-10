package com.learn.springframework.beans.context;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/4/8
 * @Descirption
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 定义注册虚拟机钩子的方法
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭
     */
    void close();
}
