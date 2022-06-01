package com.learn.springframework.beans.context.event;

import com.learn.springframework.beans.context.ApplicationEvent;
import com.learn.springframework.beans.context.ApplicationListener;
import com.learn.springframework.beans.factory.BeanFactory;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener applicationListener : getApplicationListeners(event)) {
            applicationListener.onApplicationEvent(event);
        }
    }
}
