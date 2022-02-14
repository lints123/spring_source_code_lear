package com.learn.springframework;

/**
 * @author lints
 * @Date 2022/2/11
 * @Descirption 存放Bean的对象信息
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
