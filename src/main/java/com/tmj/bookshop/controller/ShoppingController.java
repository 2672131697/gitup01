package com.tmj.bookshop.controller;

import com.tmj.bookshop.biz.IShoppingCarBiz;
import com.tmj.bookshop.model.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShoppingController {
    @Autowired
    private IShoppingCarBiz shoppingCarBiz;

    @ResponseBody
    @RequestMapping("/addCar")
    public void addCar(Model model, ShoppingCar shoppingCar){
        System.out.println(shoppingCar);
        shoppingCarBiz.addCar(shoppingCar);
        System.out.println("addCaraddCar");
    }

    @RequestMapping("/listShoppCar")
    public String listShoppCar(Model model, ShoppingCar shoppingCar){
        List<ShoppingCar> shoppingCarList = shoppingCarBiz.listShoppCar(shoppingCar);
        System.out.println(shoppingCarList);
        model.addAttribute("shoppingCarList", shoppingCarList);
        return "shoppingCar";
    }
}
