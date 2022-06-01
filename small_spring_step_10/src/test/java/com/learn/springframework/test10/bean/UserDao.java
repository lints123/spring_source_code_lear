package com.learn.springframework.test10.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDateMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "张三");
        hashMap.put("10002", "张三B");
        hashMap.put("10003", "张三C");
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
