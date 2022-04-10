package com.learn.springframework.test07.bean;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.factory.DisposableBean;
import com.learn.springframework.beans.factory.InitializingBean;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public class UserService implements InitializingBean, DisposableBean {

    private String uId;

    private String company;

    private String location;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // 销毁
    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    // 初始化
    @Override
    public void afterPropertiesSet() throws BeansException {
        System.out.println("执行：UserService.afterPropertiesSet");
    }
}
