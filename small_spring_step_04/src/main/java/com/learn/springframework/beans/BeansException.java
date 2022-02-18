package com.learn.springframework.beans;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
