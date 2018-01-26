package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IBookCategoryBiz;
import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.BookCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BookCategoryBizImplTest extends BaseTestCase {
    @Autowired
    private IBookCategoryBiz bookCategoryBiz;
    private BookCategory bookCategory;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        bookCategory = new BookCategory();
    }

    @Test
    public void listBookCategory() throws Exception {
        bookCategory.setCategoryId(1);
        List<BookCategory> bookCategoryList = bookCategoryBiz.listBookCategory(null);
        for (BookCategory b : bookCategoryList) {
            System.out.println(b);
            for(Book k:b.getListBooks()){
                System.out.println(k);
            }
        }
    }

    @Test
    public void listBookCategoryDeShu() throws Exception {
        bookCategory.setCategoryId(9);
        BookCategory b= bookCategoryBiz.listBookCategoryDeShu(bookCategory);

            System.out.println(b);
            for(Book k:b.getListBooks()){
                System.out.println(k);
            }
    }

}