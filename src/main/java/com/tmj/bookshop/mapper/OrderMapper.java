package com.tmj.bookshop.mapper;

import com.tmj.bookshop.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


    /**
     * 查看所有订单 根据订单的状态查
     * @param order
     * @return
     */
    List<Order> listOrder(Order order);

    /**
     * 查单个订单 包括查出订单明细
     * @param order
     * @return
     */
    Order loadOrder(Order order);
}