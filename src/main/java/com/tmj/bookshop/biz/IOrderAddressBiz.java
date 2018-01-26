package com.tmj.bookshop.biz;

import com.tmj.bookshop.model.OrderAddress;

import java.util.List;

public interface IOrderAddressBiz {

    /**
     * 添加订单地址
     * @param orderAddress
     * @return
     */
    Integer addOrderAddress(OrderAddress orderAddress);

    /**
     * 删除订单地址  假删除
     * @param orderAddress
     */
    void delOrderAddress(OrderAddress orderAddress);

    /**
     * 修改订单地址
     * @param orderAddress
     */
    void editOrderAddress(OrderAddress orderAddress);

    /**
     * 查单个
     * @param orderAddress
     * @return
     */
    OrderAddress loadOrderAddress(OrderAddress orderAddress);
    /**
     * 根据用户的ID 查所属的订单地址
     * @param orderAddress
     * @return
     */
    List<OrderAddress> listAddress(OrderAddress orderAddress);

    /**
     * 设置默认地址
     * @param orderAddress
     */
    void editMorenDiZhi(OrderAddress orderAddress);

    /**
     * 查默认地址(订单地址)
     */
    OrderAddress orderAddress(Integer mraddress);
}
