package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IUserBiz;
import com.tmj.bookshop.mapper.UserMapper;
import com.tmj.bookshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl implements IUserBiz {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User doLogin(User user) {
        return userMapper.doLogin(user);
    }
}
