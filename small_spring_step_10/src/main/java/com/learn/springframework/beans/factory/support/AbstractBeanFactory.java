package com.learn.springframework.beans.factory.support;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.FactoryBean;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanPostProcessor;
import com.learn.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.learn.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lints
 * @Date 2022/5/12
 * @Descirption 定义模板方法
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    // 定义后置处理器
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object[] args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<?> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    // 定义模块方法执行
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object singleton = getSingleton(name);
        if (null != singleton) {
            // 如果是FactoryBean，则调用Factory#getObject();
            return (T) getObjectForBeanInstance(singleton, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCacheObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    // Bean的定义
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    // 创建Bean
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }
}
