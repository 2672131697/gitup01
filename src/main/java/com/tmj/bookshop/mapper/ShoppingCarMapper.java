package com.tmj.bookshop.mapper;

import com.tmj.bookshop.model.Book;
import com.tmj.bookshop.model.ShoppingCar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCarMapper {
    int deleteByPrimaryKey(Integer carId);

    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(ShoppingCar carId);

    int updateByPrimaryKeySelective(ShoppingCar record);

    int updateByPrimaryKey(ShoppingCar record);

    //清空购物车 根据用户的ID
    int doQingKongCar(ShoppingCar shoppingCar);


    List<ShoppingCar> listShoppCar(ShoppingCar shoppingCar);

}