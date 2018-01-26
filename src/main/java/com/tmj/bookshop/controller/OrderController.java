package com.tmj.bookshop.controller;

import com.tmj.bookshop.biz.IOrderBiz;
import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {


    @Autowired
    private IOrderBiz orderBiz;

    @RequestMapping("/addOrder")
    public String addOrder(Model model, Order order, HttpServletRequest request, HttpSession session){
        orderBiz.addOrder(order);
        return "sucess";
    }


    /**
     * 查看所有订单 根据订单的状态查
     * @param model
     * @param order
     * @return
     */
    @RequestMapping("/listOrder")
    public String listOrder(Model model, Order order){
        List<Order> orderList = orderBiz.listOrder(order);
        model.addAttribute("orderList", orderList);
        return 0==order.getOrderStatus()?"listOrder1":1==order.getOrderStatus()?"listOrder2":"listOrder3";
    }

    /**
     * 查单个订单 包括查出订单明细
     * @param model
     * @param order
     * @param session
     * @return
     */
    @RequestMapping("/loadOrder")
    public String loadOrder(Model model, Order order,HttpSession session){
        Order o = orderBiz.loadOrder(order);
        model.addAttribute("o", o);
        return "detail";
    }
    /**
     * 发货
     * @param model
     * @param order
     * @param session
     * @return
     */
    @RequestMapping("/doFaHuo")
    public String doFaHuo(Model model, Order order,HttpSession session){

        //把订单状态修改成1(发货)
        order.setOrderStatus(1);
        orderBiz.doFaHuo(order);
        session.setAttribute("message","发货成功");
        return "redirect:listOrder?orderStatus=0";
    }

}
