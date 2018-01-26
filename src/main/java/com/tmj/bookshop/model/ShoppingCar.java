package com.tmj.bookshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCar implements Serializable{
    private Integer carId;

    private Integer bookId;

    private Integer userId;

    private Integer quantity;

    @JsonIgnore
    private Book books;


    private Integer[] bookIds;
    public ShoppingCar(Integer carId, Integer bookId, Integer userId, Integer quantity) {
        this.carId = carId;
        this.bookId = bookId;
        this.userId = userId;
        this.quantity = quantity;
    }


    public ShoppingCar() {
        super();
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public Integer[] getBookIds() {
        return bookIds;
    }

    public void setBookIds(Integer[] bookIds) {
        this.bookIds = bookIds;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "carId=" + carId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                '}';
    }
}