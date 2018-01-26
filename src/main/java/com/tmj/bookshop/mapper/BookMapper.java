package com.tmj.bookshop.mapper;

import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.BookCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);


    /**
     * 查询商品根据 商品状态查找 未上架  已上架 已下架
     * @param book
     * @return
     */
    List<Book> listBook(Book book);


    /**
     * 书本删除 不是真删 修改isvoid为1
     * @param book
     * @return
     */
    int delete(Book book);

    /**
     * 根据类别 查图书
     * @param book
     * @return
     */
    List<Book> listBookCategoryDeShu(Book book);


    /**
     * 根据销量查 前5
     * @param book
     * @return
     */
    List<Book> listBookxl(Book book);

    /**
     *
     */
    List<Book> listBookId(Book book);

}