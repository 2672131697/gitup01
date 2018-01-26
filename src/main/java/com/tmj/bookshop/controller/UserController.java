package com.tmj.bookshop.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tmj.bookshop.biz.IUserBiz;
import com.tmj.bookshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLEditorKit;

@Controller
public class UserController {

    @Autowired
    private IUserBiz userBiz;

    @ModelAttribute
    public void init(Model model,User user){

        model.addAttribute("user", user);
        System.out.println("init user");
    }

    @RequestMapping("toLogin")
    public String toLogin(Model model, User user, HttpSession session){
        session.invalidate();
        System.out.println("toLogin");
        return  "login";
    }
    @RequestMapping("doLogin")
    public String doLogin(Model model, User user, HttpSession session){
        User u = userBiz.doLogin(user);
        session.setAttribute("u",u);
        return  u==null?"login":u.getUserRole()==1?"redirect:input/index":"redirect:input/console1";
    }
}
