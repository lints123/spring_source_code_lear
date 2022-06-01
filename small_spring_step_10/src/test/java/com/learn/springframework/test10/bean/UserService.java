package com.learn.springframework.test10.bean;

/**
 * @author lints
 * @Date 2022/2/18
 * @Descirption
 */
public class UserService {
    private String uId;
    private String company;
    private String location;

    private IUserDao userDao;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }
}
