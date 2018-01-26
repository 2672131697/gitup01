package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IOrderBiz;
import com.tmj.bookshop.mapper.BookMapper;
import com.tmj.bookshop.mapper.OrderDetailMapper;
import com.tmj.bookshop.mapper.OrderMapper;
import com.tmj.bookshop.mapper.ShoppingCarMapper;
import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.Order;
import com.tmj.bookshop.model.OrderDetail;
import com.tmj.bookshop.model.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBizImpl implements IOrderBiz {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ShoppingCarMapper shoppingCarMapper;
    @Override
    public Integer addOrder(Order order) {

        //新增订单
        orderMapper.insertSelective(order);

        //同时新增订单项   可以新增多个订单项
        List<OrderDetail> orderDetailList = order.getOrderDetailList();

        Integer[] bookIds=new Integer[100];    //用来存书本的ID
        for (int i=0;i<orderDetailList.size();i++) {
            OrderDetail d = orderDetailList.get(i);
            d.setOrderId(order.getOrderId());
            orderDetailMapper.insertSelective(d);

            //订单下成功后 书本的销量加上书本的数量  书本的库存减去书本的数量
            Book b = bookMapper.selectByPrimaryKey(d.getBookId());  //根据下的订单的书本ID  查出书本

            Book book = new Book();
            book.setBookId(d.getBookId());
            book.setKucun(b.getKucun()-d.getQuantity());    // 书本的库存 等于原来的库存减去书本下单的数量
            book.setXl(b.getXl()+d.getQuantity());           //销量等于原来的销量加上下单的数量
            bookMapper.updateByPrimaryKeySelective(book);   //修改


            bookIds[i]=d.getBookId();

            //提交订单之后清空购物车 根据书本的ID 清空已经结算的书本    只清空相应的用户的购物车
            ShoppingCar shoppingCar = new ShoppingCar();
            shoppingCar.setBookIds(bookIds);
            shoppingCar.setUserId(order.getUserId());
            shoppingCarMapper.doQingKongCar(shoppingCar);

        }


        return null;
    }

    @Override
    public List<Order> listOrder(Order order) {
        return orderMapper.listOrder(order);
    }

    @Override
    public void doFaHuo(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order loadOrder(Order order) {
        return orderMapper.loadOrder(order);
    }
}
