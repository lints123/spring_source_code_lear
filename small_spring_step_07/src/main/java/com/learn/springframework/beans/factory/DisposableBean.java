package com.learn.springframework.beans.factory;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/4/10
 * @Descirption 销毁
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
