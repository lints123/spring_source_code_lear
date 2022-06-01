package com.learn.springframework.beans.context.event;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption 刷新事件
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
