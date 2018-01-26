package com.tmj.bookshop.controller;

import com.tmj.bookshop.biz.IBookCategoryBiz;
import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookCategoryController {
   @Autowired
    private IBookCategoryBiz bookCategoryBiz;

    /**
     * 书本类别 查全部
     * @param model
     * @param bookCategory
     * @return
     */
    @RequestMapping("/listBookCategory")
    public String listBookCategory(Model model, BookCategory bookCategory){
        List<BookCategory> bookCategoryList1 = bookCategoryBiz.listBookCategory(bookCategory);
        model.addAttribute("bookCategoryList1", bookCategoryList1);
        return "category";
    }


}
