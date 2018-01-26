package com.tmj.bookshop.biz;

import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.BookCategory;
import com.tmj.bookshop.util.PageBean;

import java.util.List;

public interface IBookBiz {


    Integer addBook(Book book);

    /**
     * 根据书本的状态查 未上架  已上架  已下架 的商品
     * @param book
     * @return
     */
    List<Book> listBook(Book book, PageBean pageBean);


    void delBook(Book book);

    void editBook(Book book);

    Book loadBook(Book book);

    /**
     * 根据类别 查图书
     * @param book
     * @return
     */
    List<Book> listBookCategoryDeShu(Book book,PageBean pageBean);

    /**
     * 根据销量查 前5
     * @param book
     * @return
     */
    List<Book> listBookxl(Book book);


    List<Book> listBookId(Book book);

}
