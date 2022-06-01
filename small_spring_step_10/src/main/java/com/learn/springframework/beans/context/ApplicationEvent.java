package com.learn.springframework.beans.context;

import java.util.EventObject;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption 定义事件处理
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
