package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IOrderAddressBiz;
import com.tmj.bookshop.model.OrderAddress;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class OrderAddressBizImplTest extends BaseTestCase {
    @Autowired
    private IOrderAddressBiz orderAddressBiz;
    private OrderAddress orderAddress;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        orderAddress = new OrderAddress();
    }

    @Test
    public void addOrderAddress() throws Exception {

        orderAddress.setReceiver("王五");
        orderAddress.setPhone("13973891946");
        orderAddress.setPostcode("666");
        orderAddress.setAddressName("湖南长沙");
        orderAddress.setFhfs("中通");
        orderAddress.setUserId(3);
        orderAddress.setMraddress(1);

        orderAddressBiz.addOrderAddress(orderAddress);
        System.out.println(orderAddress.getAddressId());
    }

    @Test
    public void delOrderAddress() throws Exception {
        orderAddress.setIsvoid(1);
        orderAddress.setAddressId(1);
        orderAddressBiz.delOrderAddress(orderAddress);
    }
    @Test
    public void editOrderAddress() throws Exception {
        orderAddress.setAddressId(1);
        orderAddress.setAddressName("湖南涟源");
        orderAddressBiz.editOrderAddress(orderAddress);

    }
    @Test
    public void listAddress() throws Exception {
        orderAddress.setUserId(2);
        List<OrderAddress> orderAddressList = orderAddressBiz.listAddress(orderAddress);
        for (OrderAddress o : orderAddressList) {
            System.out.println(o);
        }
    }
    @Test
    public void orderAddress() throws Exception {
        OrderAddress oa = orderAddressBiz.orderAddress(1);
        System.out.println(oa);
    }

}