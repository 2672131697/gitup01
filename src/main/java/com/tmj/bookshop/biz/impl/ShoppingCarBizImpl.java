package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IShoppingCarBiz;
import com.tmj.bookshop.mapper.ShoppingCarMapper;
import com.tmj.bookshop.model.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarBizImpl implements IShoppingCarBiz {
    @Autowired
    private ShoppingCarMapper shoppingCarMapper;
    @Override
    public void addCar(ShoppingCar shoppingCar) {

        ShoppingCar shopping = shoppingCarMapper.selectByPrimaryKey(shoppingCar);//根据书本查出购物车中的数据
        if(null==shopping){  //如果该书不在购物车中 就加入购物车中
           //加入购物车
            shoppingCarMapper.insertSelective(shoppingCar);
        }else{
            //  该书本的数量加1
            ShoppingCar s = new ShoppingCar();
            s.setCarId(shopping.getCarId());
            s.setQuantity(shopping.getQuantity()+1);
            shoppingCarMapper.updateByPrimaryKeySelective(s);
        }

    }

    @Override
    public void editCar(ShoppingCar shoppingCar) {
        shoppingCarMapper.updateByPrimaryKeySelective(shoppingCar);
    }

    @Override
    public void doQingKongCar(ShoppingCar shoppingCar) {
        shoppingCarMapper.doQingKongCar(shoppingCar);
   }

    @Override
    public List<ShoppingCar> listShoppCar(ShoppingCar shoppingCar) {
        return shoppingCarMapper.listShoppCar(shoppingCar);
    }
}
