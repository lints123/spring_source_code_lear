package com.learn.springframework.beans.context.event;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption 关闭事件
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
