package com.qfedu.service.impl;

import com.qfedu.dao.impl.CartDaoImpl;
import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.Cart;
import com.qfedu.entity.Goods;
import com.qfedu.service.CartService;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.*;

public class CartServiceImpl implements CartService {
    private CartDaoImpl cartDao = new CartDaoImpl();
    private GoodsDaoImpl goodsDao = new GoodsDaoImpl();

    @Override
    public void modifyCartByCid(String cid, String price, String num) throws SQLException {
        int newNum = Integer.parseInt(num);
        int newPrice = Integer.parseInt(price);
        int money =  newNum * newPrice;

        cartDao.modifyByCid(cid, newNum, money);
    }

    @Override
    public void createCart(int userId, String goodId) throws SQLException, InvocationTargetException, IllegalAccessException {
//        判断是否已存在此用户和对应的商品
        Cart cart = cartDao.hasCart(userId, goodId);

        if (null != cart) {
//              已存在,修改数量和小计金额
            cart.setNum(cart.getNum() + 1);
            cartDao.updateCart(cart);
        } else {
//              不存在,直接添加
            Goods goods = goodsDao.findGoodsById(goodId);
            cart = new Cart();
            cart.setNum(1);
            cart.setUid(userId);
            cart.setPid(parseInt(goodId));
            cart.setGoods(goods);

            cartDao.insertCart(cart);


        }

    }

    @Override
    public List<Cart> findCartById(int userId) throws SQLException, InvocationTargetException, IllegalAccessException {
        List<Cart> cartList = cartDao.findCartById(userId);
        return cartList;
    }

    @Override
    public void deleteCartByCid(String cid) throws SQLException {
        cartDao.deleteCartByCid(cid);
    }

    @Override
    public void deleteCartByUid(int uid) throws SQLException {
        cartDao.deleteCartByUid(uid);
    }
}
