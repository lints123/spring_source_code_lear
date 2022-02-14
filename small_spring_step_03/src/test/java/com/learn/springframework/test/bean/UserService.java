package com.learn.springframework.test.bean;

/**
 * @author lints
 * @Date 2022/2/14
 * @Descirption
 */
public class UserService {

    private String name;


    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息：" + name);
    }
}
