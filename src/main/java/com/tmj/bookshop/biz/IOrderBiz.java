package com.tmj.bookshop.biz;

import com.tmj.bookshop.model.Order;
import com.tmj.bookshop.model.OrderDetail;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface IOrderBiz {

    /**
     * 提交订单
     * @param order
     * @return
     */
    Integer addOrder(Order order);


    /**
     * 查看所有订单 根据订单的状态查
     * @param order
     * @return
     */
    List<Order> listOrder(Order order);

    /**
     * 发货
     * @param order
     */
    void doFaHuo(Order order);

    /**
     * 查单个订单 包括查出订单明细
     * @param order
     * @return
     */
    Order loadOrder(Order order);
}
