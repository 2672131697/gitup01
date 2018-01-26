package com.tmj.bookshop.controller;

import com.tmj.bookshop.biz.IOrderAddressBiz;
import com.tmj.bookshop.model.OrderAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderAddressController {

    @Autowired
    private IOrderAddressBiz orderAddressBiz;


    @ModelAttribute
    public void init(Model model, OrderAddress orderAddress){
        model.addAttribute("orderAddress", orderAddress);
        System.out.println("init orderAddress");
    }
    @RequestMapping("/toAddOrderAddress")
    public String toAddOrderAddress(Model model, OrderAddress orderAddress){
        System.out.println("toAddOrderAddress");
        return "addOrder";
    }
    /**
     * 新增地址
     * @param model
     * @param orderAddress
     * @return
     */
    @RequestMapping("/addOrderAddress")
    public String addOrderAddress(Model model, OrderAddress orderAddress){
        orderAddressBiz.addOrderAddress(orderAddress);
        return "redirect:input/order";
    }
    @RequestMapping("/toEditOrderAddress")
    public String toEditOrderAddress(Model model, OrderAddress orderAddress){
        System.out.println("toEditOrderAddress");
        OrderAddress loadOrderAddress= orderAddressBiz.loadOrderAddress(orderAddress);
        model.addAttribute("loadOrderAddress", loadOrderAddress);
        return "editOrder";
    }

    /**
     * 修改收货信息
     * @param model
     * @param orderAddress
     * @param session
     * @return
     */
    @RequestMapping("/editOrderAddress")
    public String editOrderAddress(Model model, OrderAddress orderAddress, HttpSession session){
        orderAddressBiz.editOrderAddress(orderAddress);
        session.setAttribute("message","收货地址修改成功");
        return "redirect:listAddress?userId="+orderAddress.getUserId();
    }
    /**
     *根据用户的ID 查所属的订单地址
     * @param model
     * @param orderAddress
     * @return
     */
    @RequestMapping("/listAddress")
    public String listAddress(Model model, OrderAddress orderAddress){
        List<OrderAddress> orderAddressList = orderAddressBiz.listAddress(orderAddress);
        model.addAttribute("orderAddressList", orderAddressList);
        return  "order";
    }

    /**
     * 设置默认地址
     * @param model
     * @param orderAddress
     * @return
     */
    @RequestMapping("/editMorenDiZhi")
    public String editMorenDiZhi(Model model, OrderAddress orderAddress,HttpSession session){
        orderAddressBiz.editMorenDiZhi(orderAddress);
        session.setAttribute("message","设置成功");
        //查询订单的地址(默认地址)
        OrderAddress oa = orderAddressBiz.orderAddress(1);
        session.setAttribute("oa", oa);
        return "redirect:listAddress?userId="+orderAddress.getUserId();
    }
}
