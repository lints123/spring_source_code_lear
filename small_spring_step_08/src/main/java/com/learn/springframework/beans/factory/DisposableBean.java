package com.learn.springframework.beans.factory;

/**
 * @author lints
 * @Date 2022/4/25
 * @Descirption 销毁方法接口
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
