package com.learn.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @author lints
 * @Date 2022/2/15
 * @Descirption
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "学习A");
        hashMap.put("10002", "学习B");
        hashMap.put("10003", "学习C");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
