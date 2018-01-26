package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IOrderBiz;
import com.tmj.bookshop.biz.IOrderDetailBiz;
import com.tmj.bookshop.model.Order;
import com.tmj.bookshop.model.OrderDetail;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderBizImplTest extends BaseTestCase {
    @Autowired
    private IOrderBiz orderBiz;
    @Autowired
    private IOrderDetailBiz orderDetailBiz;
    private Order order;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        order = new Order();
    }

    @Test
    public void addOrder() throws Exception {

        order.setAddressId(3);
        order.setPayway("支付宝");
        order.setUserId(3);


        // 订单项
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(order.getOrderId());
        orderDetail.setBookId(11);
        orderDetail.setQuantity(3);
        orderDetails.add(0,orderDetail);

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setOrderId(order.getOrderId());
        orderDetail1.setBookId(13);
        orderDetail1.setQuantity(3);
        orderDetails.add(1,orderDetail1);
        order.setOrderDetailList(orderDetails);

        orderBiz.addOrder(order);

        System.out.println("orderId="+order.getOrderId());

    }

    @Test
    public void listOrder() throws Exception {

        order.setOrderStatus(0);
        List<Order> orderList = orderBiz.listOrder(order);
        for (Order o : orderList) {
            System.out.println(o);
            System.out.println(o.getOrderAddress());
        }
    }
    @Test
    public void loadOrder() throws Exception {

        order.setOrderId(15);
        Order o = orderBiz.loadOrder(order);
        System.out.println(o);
        for (OrderDetail od : o.getOrderDetailList()) {
            System.out.println(od);
            System.out.println(od.getBook());
        }
    }

}