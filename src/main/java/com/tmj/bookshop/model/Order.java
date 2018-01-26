package com.tmj.bookshop.model;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Order implements Serializable{
    private Integer orderId;

    private Integer addressId;

    private String payway;

    private Date maketime;

    private Integer orderStatus;

    private Integer userId;



    //保存订单项的集合
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

    //订单地址
    private OrderAddress orderAddress;

    //书本
    private List<Book> listBooks = new ArrayList<Book>();


    //用户
    private User user;
    private Float ddzj;

    public Order(Integer orderId, Integer addressId, String payway, Date maketime, Integer orderStatus, Integer userId) {
        this.orderId = orderId;
        this.addressId = addressId;
        this.payway = payway;
        this.maketime = maketime;
        this.orderStatus = orderStatus;
        this.userId = userId;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public Date getMaketime() {
        return maketime;
    }

    public void setMaketime(Date maketime) {
        this.maketime = maketime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public OrderAddress getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public Float getDdzj() {
        return ddzj;
    }

    public void setDdzj(Float ddzj) {
        this.ddzj = ddzj;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", addressId=" + addressId +
                ", payway='" + payway + '\'' +
                ", maketime=" + maketime +
                ", orderStatus=" + orderStatus + ", userId=" + userId + ",ddzj="+ddzj+'}';
    }
}