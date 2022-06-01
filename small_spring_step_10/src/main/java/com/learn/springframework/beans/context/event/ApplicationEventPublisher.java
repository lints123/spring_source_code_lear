package com.learn.springframework.beans.context.event;

import com.learn.springframework.beans.context.ApplicationEvent;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption 定义事件的发布接口。所有的事件都要经过这个发布。
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}
