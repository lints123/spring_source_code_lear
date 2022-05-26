package com.learn.springframework.beans.context;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.Aware;

/**
 * @author lints
 * @Date 2022/5/7
 * @Descirption 实现此接口，既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
