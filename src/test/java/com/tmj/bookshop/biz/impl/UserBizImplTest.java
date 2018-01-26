package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IUserBiz;
import com.tmj.bookshop.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserBizImplTest extends BaseTestCase{
    @Autowired
    private IUserBiz userBiz;
    private User user;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        user = new User();
    }

    @Test
    public void doLogin() throws Exception {

        user.setUserName("ls");
        user.setUserPwd("123456");
        System.out.println(userBiz.doLogin(user));
    }

}