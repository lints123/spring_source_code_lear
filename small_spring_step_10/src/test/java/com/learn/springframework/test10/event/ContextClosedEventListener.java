package com.learn.springframework.test10.event;

import com.learn.springframework.beans.context.ApplicationListener;
import com.learn.springframework.beans.context.event.ContextClosedEvent;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
