package com.learn.springframework.beans.context.event;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.context.ApplicationEvent;
import com.learn.springframework.beans.context.ApplicationListener;
import com.learn.springframework.beans.factory.BeanFactory;
import com.learn.springframework.beans.factory.BeanFactoryAware;
import com.learn.springframework.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author lints
 * @Date 2022/6/1
 * @Descirption
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationListener> allListeners = new LinkedList<ApplicationListener>();

        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            // 校验当前监听和发送的事件是否是从属关系
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 按照CglibSubClassInstantiationStrategy、SimpleInstantiationStrategy 不同实例化类型，需要判断后获取目标Class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;

        // 返回表示当前对象所表示的类或接口直接实现的接口类型
        Type genericInterFaces = targetClass.getGenericInterfaces()[0];

        // 转化为参数化类型
        ParameterizedType parameterizedType = (ParameterizedType) genericInterFaces;

        // 获取参数的实际类型
        Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];

        String className = actualTypeArgument.getTypeName();

        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        // 判断eventClassName对象表示的类或者接口跟指定的event.getClass() 参数表示的类或者接口是否相同，是否是其超类或者超接口。
        // isAssignableFrom是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，默认所有的类的终极父类都是Object。
        // 如果A.isAssignableFrom(B)结果是true，证明B可以转换成为A,也就是A可以由B转换而来。
        return eventClassName.isAssignableFrom(event.getClass());
    }

}
