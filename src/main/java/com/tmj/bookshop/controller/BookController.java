package com.tmj.bookshop.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tmj.bookshop.biz.IBookBiz;
import com.tmj.bookshop.biz.IBookCategoryBiz;
import com.tmj.bookshop.biz.IFileUploadRecordBiz;
import com.tmj.bookshop.biz.IOrderAddressBiz;
import com.tmj.bookshop.exception.CustomException;
import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.BookCategory;
import com.tmj.bookshop.model.FileUploadRecord;
import com.tmj.bookshop.model.OrderAddress;
import com.tmj.bookshop.util.MimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {

    @Autowired
    private IBookCategoryBiz bookCategoryBiz;
    @Autowired
    private IBookBiz bookBiz;

    @Autowired
    private IFileUploadRecordBiz fileUploadRecordBiz;

    @Autowired
    private IOrderAddressBiz orderAddressBiz;
    private String saveDir = "d:\\temp\\";

    @ModelAttribute
    public void init(Model model, Book book){
        model.addAttribute("book", book);
        System.out.println("init book");
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model, Book book){
        //加载下拉框的数据
        List<BookCategory> bookCategoryList = bookCategoryBiz.listBookCategory(null);
        model.addAttribute("bookCategoryList",bookCategoryList);
        System.out.println("toAddBook");
        return "addBook";
    }
    /**
     * 书本新增
     * @param model
     * @param book
     * @param session
     * @return
     */
    @RequestMapping("/doAddBook")
    public String doAddBook(Model model, Book book,HttpSession session,MultipartFile img) throws Exception{

        if (!img.isEmpty()){
            //原文件的名称
            String fileName=img.getOriginalFilename();
            //新文件的名称
           String fileId= UUID.randomUUID().toString().replace("-","");
            //新的图片
            File file = new File(saveDir + fileId);
            img.transferTo(file);
            // 1. 文件的保存路径
            String path = this.saveDir+ fileId;// 没有后缀名

            // 向数据库保存一条文件的上传记录
            FileUploadRecord fileUploadRecord = new FileUploadRecord();
            fileUploadRecord.setFileId(fileId);
            fileUploadRecord.setFilePath(path);
            fileUploadRecord.setFileName(fileName);
            fileUploadRecord.setMime(MimeUtils.getMime(fileName));
            fileUploadRecordBiz.add(fileUploadRecord);

            //往图片字段里加上 fileId
            book.setCover(fileId);
        }
        bookBiz.addBook(book);
        session.setAttribute("message","书本新增成功");
        System.out.println("bookId:"+ book.getBookId());
        return "redirect:toAddBook";
    }
    @RequestMapping("/listBook")
    public String listBook(Model model, Book book,String forward){
        List<Book> bookList = bookBiz.listBook(book, null);
        model.addAttribute("bookList",bookList);
        System.out.println(bookList);
        return "listBook1".equals(forward)?"listBook1":"listBook2".equals(forward)?"listBook2":"listBook3";
    }

    /**
     * 删除书本
     * @param model
     * @param book
     * @return
     */
    @RequestMapping("/delBook")
    public String delBook(Model model, Book book,HttpSession session){
        bookBiz.delBook(book);
        session.setAttribute("message","书本删除成功");
        return "redirect:listBook?forward=listBook1&bookStatus=0";
    }

    /**
     * 跳转到书本修改页面
     * @param model
     * @param book
     * @return
     */
    @RequestMapping("/toEditBook")
    public String toEditBook(Model model, Book book)throws Exception{
        //加载下拉框的数据
        List<BookCategory> bookCategoryList = bookCategoryBiz.listBookCategory(null);
        model.addAttribute("bookCategoryList",bookCategoryList);

        //查单个
        Book b = bookBiz.loadBook(book);
        if(b==null){
            throw new CustomException("修改的书本信息不存在");
        }
        model.addAttribute("b",b);
        return "editBook";
    }
    /**
     * 修改书本
     * @param model
     * @param book
     * @return
     */
    @RequestMapping("/doEditBook")
    public String doEditBook(Model model, Book book,HttpSession session,MultipartFile img)throws Exception{
        if(!img.isEmpty()){
            //原文件的名称
            String fileName=img.getOriginalFilename();
            //新文件的名称
            String fileId= UUID.randomUUID().toString().replace("-","");
            //新的图片
            File file = new File(saveDir + fileId);
            img.transferTo(file);
            // 1. 文件的保存路径
            String path = this.saveDir+ fileId;// 没有后缀名
            // 向数据库保存一条文件的上传记录
            FileUploadRecord fileUploadRecord = new FileUploadRecord();
            fileUploadRecord.setFileId(fileId);
            fileUploadRecord.setFilePath(path);
            fileUploadRecord.setFileName(fileName);
            fileUploadRecord.setMime(MimeUtils.getMime(fileName));
            fileUploadRecordBiz.add(fileUploadRecord);
            //往图片字段里加上 fileId
            book.setCover(fileId);
        }
        bookBiz.editBook(book);
        session.setAttribute("message","书本修改成功");
        return "redirect:listBook?forward=listBook1&bookStatus=0";
    }

    /**
     * 书本上架
     * @param model
     * @param book
     * @param session
     * @return
     */
    @RequestMapping("/doSj")
    public String doSj(Model model, Book book,HttpSession session){
        book.setBookStatus(1);
        book.setSjtime(new Timestamp(System.currentTimeMillis()));
        bookBiz.editBook(book);
        session.setAttribute("message","书本上架成功");
        System.out.println(book);
        return "redirect:listBook?forward=listBook1&bookStatus=0";
    }

    /**
     * 书本下架
     * @param model
     * @param book
     * @param session
     * @return
     */
    @RequestMapping("/doXj")
    public String doXj(Model model, Book book,HttpSession session){
        book.setBookStatus(2);
        bookBiz.editBook(book);
        session.setAttribute("message","书本下架成功");
        System.out.println(book);
        return "redirect:listBook?forward=listBook2&bookStatus=1";
    }

    /**
     * 上传封面
     * @param model
     * @param book
     * @param session
     * @param img
     * @return
     */
    @RequestMapping("/uploadImage")
    public String uploadImage(Model model, Book book,HttpSession session,MultipartFile img) throws Exception{
        if(!img.isEmpty()){
            //原文件的名称
            String fileName=img.getOriginalFilename();
            //新文件的名称
            String fileId= UUID.randomUUID().toString().replace("-","");
            //新的图片
            File file = new File(saveDir + fileId);
            img.transferTo(file);
            // 1. 文件的保存路径
            String path = this.saveDir+ fileId;// 没有后缀名
            // 向数据库保存一条文件的上传记录
            FileUploadRecord fileUploadRecord = new FileUploadRecord();
            fileUploadRecord.setFileId(fileId);
            fileUploadRecord.setFilePath(path);
            fileUploadRecord.setFileName(fileName);
            fileUploadRecord.setMime(MimeUtils.getMime(fileName));
            fileUploadRecordBiz.add(fileUploadRecord);
            //往图片字段里加上 fileId
            book.setCover(fileId);
            bookBiz.editBook(book);
            session.setAttribute("message", "封面上传成功");
        }else{
            session.setAttribute("message", "请选择图片");
        }
        return !img.isEmpty()?"redirect:listBook?forward=listBook1&bookStatus=0":"uploadBookImage";
    }


    /**
     * 文件下载  直接打开
     * @param model
     * @param fileId
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/open")
    public void open(Model model, String fileId, HttpServletResponse response) throws ServletException, IOException{
        FileUploadRecord f = fileUploadRecordBiz.load(fileId);
        String fileName=f.getFileName();
        response.setHeader("content-disposition","filename=\""+fileName+"\"");

        //2.io流读写文件
        InputStream is=new FileInputStream(new File(f.getFilePath()));
        OutputStream os =response.getOutputStream();
        byte[] b=new byte[1024];
        int len=-1;
        while((len=is.read(b))!=-1){
            os.write(b, 0, len);
        }
        is.close();
        os.close();
    }

    /**
     * index页面的查询 热销图书 最新上架图书
     * @param model
     * @param book
     * @param
     * @return
     */
    @RequestMapping("/xshjListBook")
    public String xshjListBook(Model model, Book book){
        book.setBookStatus(1); //已上架
        book.setWxhn("xssj"); //新书上架
        List<Book> xshjListBook = bookBiz.listBook(book, null);   //热销图书
        model.addAttribute("xshjListBook", xshjListBook);
        List<Book> xlListBookxl = bookBiz.listBookxl(book);//销量排前的图书
        model.addAttribute("xlListBookxl", xlListBookxl);
        return "index";
    }


    /**
     * 根据类别查 对面的图书
     * @param model
     * @param
     * @return
     */
    @RequestMapping("/listBookCategoryDeShu")
    public String listBookCategoryDeShu(Model model,Book book){

        List<Book> bookList = bookBiz.listBookCategoryDeShu(book, null);
        model.addAttribute("bookList", bookList);
        System.out.println("listBookCategoryDeShulistBookCategoryDeShulistBookCategoryDeShu");
        return "findBook";
    }

    @RequestMapping("/jieShuBook")
    public String jieShuBook(Model model,Book book,OrderAddress orderAddress,HttpSession session,String forward){
        //根据用户的ID 查所属的订单地址
        List<OrderAddress> orderAddressList = orderAddressBiz.listAddress(orderAddress);
        model.addAttribute("orderAddressList", orderAddressList);

        //根据书本ID 查书本信息

            List<Book> books = bookBiz.listBookId(book);
            System.out.println(books);
            session.setAttribute("books", books);
        //查询订单的地址(默认地址)
        OrderAddress oa = orderAddressBiz.orderAddress(1);
        session.setAttribute("oa", oa);
        return "order";
    }


    @RequestMapping("/jieShuBook2")
    public String jieShuBook2(Model model,Book book,OrderAddress orderAddress,HttpSession session,String forward){
        //根据用户的ID 查所属的订单地址
        List<OrderAddress> orderAddressList = orderAddressBiz.listAddress(orderAddress);
        model.addAttribute("orderAddressList", orderAddressList);

        //根据书本ID 查书本信息

        List<Book> books = bookBiz.listBookId(book);
        System.out.println(books);
        session.setAttribute("books", books);
        //查询订单的地址(默认地址)
        OrderAddress oa = orderAddressBiz.orderAddress(1);
        session.setAttribute("oa", oa);
        return "order";
    }
}
