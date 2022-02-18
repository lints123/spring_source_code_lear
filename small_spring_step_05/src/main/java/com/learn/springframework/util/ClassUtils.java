package com.learn.springframework.util;

import javafx.scene.chart.ScatterChart;

/**
 * @author lints
 * @Date 2022/2/15
 * @Descirption
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

}
