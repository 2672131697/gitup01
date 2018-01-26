package com.tmj.bookshop.biz;

import com.tmj.bookshop.model.ShoppingCar;

import java.util.List;

public interface IShoppingCarBiz {

    /**
     * 新增商品到购物车
     * @param shoppingCar
     */
    void addCar (ShoppingCar shoppingCar);

    /**
     * 修改购物车中的商品数量
     * @param shoppingCar
     */
    void editCar(ShoppingCar shoppingCar);


    /**
     * 根据用户的ID 清空购物车
     * @param shoppingCar
     */
   void doQingKongCar(ShoppingCar shoppingCar);

    List<ShoppingCar> listShoppCar(ShoppingCar shoppingCar);
}
