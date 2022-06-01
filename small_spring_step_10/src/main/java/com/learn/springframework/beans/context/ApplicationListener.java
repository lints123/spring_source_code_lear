package com.learn.springframework.beans.context;

import java.util.EventListener;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption 事件监听器
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);

}
