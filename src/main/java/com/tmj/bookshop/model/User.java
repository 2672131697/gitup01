package com.tmj.bookshop.model;

import java.io.Serializable;

public class User implements Serializable{

    private Integer userId;

    private String userName;

    private String userPwd;

    private Integer userRole;

    public User(Integer userId, String userName, String userPwd, Integer userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRole = userRole;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}