package com.tmj.bookshop.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
    private Integer bookId;

    private String bookName;

    private Integer categoryId;

    private String bookAuthor;

    private Float bookPrice;

    private String bookPress;

    private String remark;

    private Integer bookStatus;

    private Integer kucun;

    private Integer xl;

    private Date sjtime;

    private String cover;

    private Integer isvoid;


    private BookCategory bookCategorys;


    // 根据这个字段来实现 显示最新上架图书 和 热销图书
    private String wxhn;


    private ShoppingCar shoppingCar;

    private Integer[] bookIds;
    public Book(Integer bookId, String bookName, Integer categoryId, String bookAuthor, Float bookPrice, String bookPress, String remark, Integer bookStatus, Integer kucun, Integer xl, Date sjtime, String cover, Integer isvoid) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.categoryId = categoryId;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookPress = bookPress;
        this.remark = remark;
        this.bookStatus = bookStatus;
        this.kucun = kucun;
        this.xl = xl;
        this.sjtime = sjtime;
        this.cover = cover;
        this.isvoid = isvoid;
    }

    public Book() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer getKucun() {
        return kucun;
    }

    public void setKucun(Integer kucun) {
        this.kucun = kucun;
    }

    public Integer getXl() {
        return xl;
    }

    public void setXl(Integer xl) {
        this.xl = xl;
    }

    public Date getSjtime() {
        return sjtime;
    }

    public void setSjtime(Date sjtime) {
        this.sjtime = sjtime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getIsvoid() {
        return isvoid;
    }

    public void setIsvoid(Integer isvoid) {
        this.isvoid = isvoid;
    }

    public String getWxhn() {
        return wxhn;
    }

    public void setWxhn(String wxhn) {
        this.wxhn = wxhn;
    }

    public BookCategory getBookCategorys() {
        return bookCategorys;
    }

    public void setBookCategorys(BookCategory bookCategorys) {
        this.bookCategorys = bookCategorys;
    }

    public Integer[] getBookIds() {
        return bookIds;
    }

    public void setBookIds(Integer[] bookIds) {
        this.bookIds = bookIds;
    }

    public ShoppingCar getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(ShoppingCar shoppingCar) {
        this.shoppingCar = shoppingCar;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", categoryId=" + categoryId +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookPress='" + bookPress + '\'' +
                ", remark='" + remark + '\'' +
                ", bookStatus=" + bookStatus +
                ", kucun=" + kucun +
                ", xl=" + xl +
                ", sjtime=" + sjtime +
                ", cover='" + cover + '\'' +
                ", isvoid=" + isvoid +
                '}';
    }
}