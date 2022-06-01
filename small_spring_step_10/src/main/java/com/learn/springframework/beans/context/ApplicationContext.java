package com.learn.springframework.beans.context;

import com.learn.springframework.beans.context.event.ApplicationEventPublisher;
import com.learn.springframework.beans.factory.ListableBeanFactory;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption
 */
public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher {

}
