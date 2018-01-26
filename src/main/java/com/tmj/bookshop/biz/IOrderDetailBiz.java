package com.tmj.bookshop.biz;

import com.tmj.bookshop.model.OrderDetail;

public interface IOrderDetailBiz {


    /**
     * 新增订单明细
     * @param orderDetail
     * @return
     */
    Integer addOrderDetailBiz(OrderDetail orderDetail);
}
