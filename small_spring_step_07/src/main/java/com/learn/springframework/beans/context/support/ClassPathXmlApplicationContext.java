package com.learn.springframework.beans.context.support;

/**
 * @author lints
 * @Date 2022/4/10
 * @Descirption
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configlocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configlocation) {
        this(new String[]{configlocation});
    }

    public ClassPathXmlApplicationContext(String[] configlocations) {
        this.configlocations = configlocations;
        refresh();
    }


    @Override
    protected String[] getConfigLocations() {
        return configlocations;
    }
}
