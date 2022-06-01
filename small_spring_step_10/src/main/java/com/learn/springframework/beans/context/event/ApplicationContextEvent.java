package com.learn.springframework.beans.context.event;

import com.learn.springframework.beans.context.ApplicationContext;
import com.learn.springframework.beans.context.ApplicationEvent;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
