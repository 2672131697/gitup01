package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IOrderAddressBiz;
import com.tmj.bookshop.mapper.OrderAddressMapper;
import com.tmj.bookshop.model.OrderAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAddressBizImpl implements IOrderAddressBiz {

    @Autowired
    private OrderAddressMapper orderAddressMapper;
    @Override
    public Integer addOrderAddress(OrderAddress orderAddress) {

        //新增用户订单地址  //新增的用户地址默认是1
        return orderAddressMapper.insertSelective(orderAddress);
    }

    @Override
    public void delOrderAddress(OrderAddress orderAddress) {
        orderAddressMapper.updateByPrimaryKeySelective(orderAddress);
    }

    @Override
    public void editOrderAddress(OrderAddress orderAddress) {
        orderAddressMapper.updateByPrimaryKeySelective(orderAddress);
    }

    @Override
    public List<OrderAddress> listAddress(OrderAddress orderAddress) {
        return orderAddressMapper.listAddress(orderAddress);
    }

    @Override
    public OrderAddress loadOrderAddress(OrderAddress orderAddress) {
        return orderAddressMapper.selectByPrimaryKey(orderAddress.getAddressId());
    }

    @Override
    public void editMorenDiZhi(OrderAddress orderAddress) {

        //在设置默认地址之前  把用户原来的地址mraddress 改成0
        //根据用户ID 把默认地址 设为0 (否)  传userId
       orderAddressMapper.editMoRenAddress(orderAddress);

        //根据addressId 把mraddress  改成1(默认地址)
        orderAddress.setMraddress(1);
        orderAddressMapper.updateByPrimaryKeySelective(orderAddress);  //传addressId
    }

    @Override
    public OrderAddress orderAddress(Integer mraddress) {
        return orderAddressMapper.orderAddress(mraddress);
    }
}
