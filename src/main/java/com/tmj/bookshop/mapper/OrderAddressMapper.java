package com.tmj.bookshop.mapper;

import com.tmj.bookshop.model.OrderAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(OrderAddress record);

    int insertSelective(OrderAddress record);

    OrderAddress selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(OrderAddress record);

    int updateByPrimaryKey(OrderAddress record);

    /**
     * 根据用户的ID 查所属的订单地址
     * @param orderAddress
     * @return
     */
    List<OrderAddress> listAddress(OrderAddress orderAddress);

    /**
     * 根据用户ID 把默认地址 设为0 (否)
     * @param orderAddress
     * @return
     */
    int editMoRenAddress(OrderAddress orderAddress);

    /**
     * 查默认地址(订单地址)
     */
    OrderAddress orderAddress(Integer mraddress);
}