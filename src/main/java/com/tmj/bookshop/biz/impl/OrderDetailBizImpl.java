package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IOrderDetailBiz;
import com.tmj.bookshop.mapper.OrderDetailMapper;
import com.tmj.bookshop.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailBizImpl implements IOrderDetailBiz {
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public Integer addOrderDetailBiz(OrderDetail orderDetail) {
        return orderDetailMapper.insertSelective(orderDetail);
    }
}
