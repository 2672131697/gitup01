package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IBookBiz;
import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.BookCategory;
import com.tmj.bookshop.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BookBizImplTest extends BaseTestCase {
    @Autowired
    private IBookBiz bookBiz;
    private Book book;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        book = new Book();
    }

    @Test
    public void addBook() throws Exception {
        book.setBookName("冷间谍");
        book.setCategoryId(1);
        book.setBookAuthor("亨宁曼凯尔");
        book.setBookPrice(28.5f);
        book.setBookPress("江苏文艺出版社");
        book.setRemark("东野圭吾最钦佩的欧洲犯罪小说大师力作。把“哈利波特”拉下畅销榜榜首的侦探小说。最匪夷所思的历史真相、最错综复杂的政治斗争、最神秘莫测的间谍形象，最完美的罪犯与最完美的犯罪，结局你永远猜不到");
        book.setXl(0);
        book.setKucun(30);
        bookBiz.addBook(book);
        System.out.println(book.getBookId());

    }

    @Test
    public void listBook() throws Exception {
       /* PageBean pageBean =new PageBean();
        pageBean.setCurPage(1);
        pageBean.setPageRecord(2);*/
        book.setBookStatus(1);
        book.setWxhn("xssj");
        List<Book> bookList = bookBiz.listBook(book, null);
        for (Book b : bookList) {
            System.out.println(b);
        }
    }
    @Test
    public void listBookCategoryDeShu() throws Exception {
        book.setCategoryId(1);
        List<Book> books = bookBiz.listBookCategoryDeShu(book, null);
        for (Book b : books) {
            System.out.println(b);
        }

    }
    @Test
    public void listBookxl() throws Exception {

        List<Book> listBookxl = bookBiz.listBookxl(book);
        for (Book b : listBookxl) {
            System.out.println(b);
        }
    }
    @Test
    public void listBookId() throws Exception {

        book.setBookIds(new Integer[]{11,12,13});
        List<Book> books = bookBiz.listBookId(book);
        for (Book b : books) {
            System.out.println(b);
        }
    }

}