package com.learn.springframework.test08.bean;

import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.context.ApplicationContext;
import com.learn.springframework.beans.context.ApplicationContextAware;
import com.learn.springframework.beans.factory.*;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public class UserService implements BeanNameAware, ApplicationContextAware, BeanClassLoaderAware, BeanFactoryAware {


    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

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
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("执行：UserService.destroy");
//    }
//
//    // 初始化
//    @Override
//    public void afterPropertiesSet() throws BeansException {
//        System.out.println("执行：UserService.afterPropertiesSet");
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
