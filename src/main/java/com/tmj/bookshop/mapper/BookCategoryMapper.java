package com.tmj.bookshop.mapper;

import com.tmj.bookshop.model.BookCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);

    List<BookCategory> listBookCategory(BookCategory bookCategory);

    BookCategory listBookCategoryDeShu(BookCategory bookCategory);
}