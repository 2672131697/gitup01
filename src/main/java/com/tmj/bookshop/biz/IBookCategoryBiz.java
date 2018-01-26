package com.tmj.bookshop.biz;

import com.tmj.bookshop.model.BookCategory;

import java.util.List;

public interface IBookCategoryBiz{

    List<BookCategory> listBookCategory(BookCategory bookCategory);

    BookCategory listBookCategoryDeShu(BookCategory bookCategory);
}
