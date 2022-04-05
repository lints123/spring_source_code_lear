package com.learn.springframework.beans.context.support;

import com.learn.springframework.beans.BeansException;

/**
 * @author lints
 * @Date 2022/4/4
 * @Descirption 具体对外给用户提供的应用上下文方法。
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configlocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     * @param configlocation
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configlocation) throws BeansException{
        this(new String[]{configlocation});
    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     * @param configlocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configlocations) throws BeansException {
        this.configlocations = configlocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations(){
        return configlocations;
    }
}
