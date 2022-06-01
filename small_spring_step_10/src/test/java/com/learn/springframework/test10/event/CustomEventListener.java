package com.learn.springframework.test10.event;

import com.learn.springframework.beans.context.ApplicationListener;

import java.util.Date;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
