package com.learn.springframework.test10.event;

import com.learn.springframework.beans.context.ApplicationListener;
import com.learn.springframework.beans.context.event.ContextRefreshedEvent;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption
 */
public class ContextRefreshEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
