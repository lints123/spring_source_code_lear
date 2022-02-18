package com.learn.springframework.beans;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
