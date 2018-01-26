package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IShoppingCarBiz;
import com.tmj.bookshop.model.ShoppingCar;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ShoppingCarBizImplTest extends BaseTestCase {

    @Autowired
    private IShoppingCarBiz shoppingCarBiz;
    private ShoppingCar shoppingCar;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        shoppingCar = new ShoppingCar();
    }

    @Test
    public void addCar() throws Exception {

        shoppingCar.setBookId(13);
        shoppingCar.setUserId(3);
        shoppingCar.setQuantity(2);
        shoppingCarBiz.addCar(shoppingCar);

    }

    @Test
    public void editCar() throws Exception {
    }

    @Test
    public void doQingKongCar() throws Exception {
    }

}