package com.learn.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.DisposableBean;
import com.learn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author lints
 * @Date 2022/4/25
 * @Descirption
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    // 执行销毁方法
    @Override
    public void destroy() throws Exception {

        // 接口实现
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // xml配置实现
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }

    }
}
