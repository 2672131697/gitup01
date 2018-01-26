package com.tmj.bookshop.controller;

import com.tmj.bookshop.biz.IBookBiz;
import com.tmj.bookshop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 与Json交互
 */

@Controller
public class JsonTest {
    @Autowired
    private IBookBiz bookBiz;
    //请求的是Json 输出的也是Json
    @RequestMapping("/requestJson")
    //@RequestBody  将请求的书本信息的Json串转成book对象
    //@ResponseBody 将book对象转成Json串输出
    public @ResponseBody Book requestJson(@RequestBody Book book){
        System.out.println(book);
        return book;
    }

    @RequestMapping("/responseJson")
    public @ResponseBody Book responseJson(Book book){
        System.out.println(book);
        return book;
    }

    //{bookId}表示将这个位置的参数传到@PathVariable指定名称中
    @RequestMapping("/bookView/{bookId}")
    public @ResponseBody Book bookView(@PathVariable("bookId") Integer bookId){
        Book book = new Book();
        book.setBookId(bookId);
        Book b=bookBiz.loadBook(book);
        System.out.println(b);
        return b;
    }

}
