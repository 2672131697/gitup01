package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IBookBiz;
import com.tmj.bookshop.mapper.BookMapper;
import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.BookCategory;
import com.tmj.bookshop.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBizImpl implements IBookBiz {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public Integer addBook(Book book) {
        return bookMapper.insertSelective(book);
    }

    @Override
    public List<Book> listBook(Book book, PageBean pageBean) {
        return bookMapper.listBook(book);
    }

    @Override
    public void delBook(Book book) {
        bookMapper.delete(book);
    }

    @Override
    public void editBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public Book loadBook(Book book) {
        return bookMapper.selectByPrimaryKey(book.getBookId());
    }

    @Override
    public List<Book> listBookCategoryDeShu(Book book,PageBean pageBean) {
        return bookMapper.listBookCategoryDeShu(book);
    }

    @Override
    public List<Book> listBookxl(Book book) {
        return bookMapper.listBookxl(book);
    }

    @Override
    public List<Book> listBookId(Book book) {
        return bookMapper.listBookId(book);
    }
}
