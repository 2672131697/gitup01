package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IBookCategoryBiz;
import com.tmj.bookshop.mapper.BookCategoryMapper;
import com.tmj.bookshop.model.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryBizImpl implements IBookCategoryBiz {
    @Autowired
    private BookCategoryMapper bookCategoryMapper;
    @Override
    public List<BookCategory> listBookCategory(BookCategory bookCategory) {
        return bookCategoryMapper.listBookCategory(bookCategory);
    }

    @Override
    public BookCategory listBookCategoryDeShu(BookCategory bookCategory) {
        return bookCategoryMapper.listBookCategoryDeShu(bookCategory);
    }
}
