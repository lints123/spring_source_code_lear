package com.learn.springframework.beans.context.event;

import com.learn.springframework.beans.context.ApplicationEvent;
import com.learn.springframework.beans.context.ApplicationListener;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption 事件广播器
 */
public interface ApplicationEventMulticaster {

    // 添加监听
    void addApplicationListener(ApplicationListener<?> listener);

    // 删除监听
    void removeApplicationListener(ApplicationListener<?> listener);

    // 广播事件
    void multicastEvent(ApplicationEvent event);


}
