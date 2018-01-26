package com.tmj.bookshop.model;

public class OrderDetail {
    private Integer orderdetailId;

    private Integer orderId;

    private Integer bookId;

    private Integer quantity;


    //一对一 一个订单明细对应一本书
    private Book book;
    public OrderDetail(Integer orderdetailId, Integer orderId, Integer bookId, Integer quantity) {
        this.orderdetailId = orderdetailId;
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public OrderDetail() {
        super();
    }

    public Integer getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(Integer orderdetailId) {
        this.orderdetailId = orderdetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderdetailId=" + orderdetailId +
                ", orderId=" + orderId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                '}';
    }
}