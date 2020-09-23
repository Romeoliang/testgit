package com.qfedu.service;

import com.qfedu.entity.Cart;
import com.qfedu.entity.Goods;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


public interface CartService {

    /**
     * 修改购物车信息
     *
     * @param cid   购物车id
     * @param price 商品价格
     * @param num   数量
     * @throws SQLException 抛出异常
     */
    void modifyCartByCid(String cid, String price, String num) throws SQLException;

    /**
     * 创建购物车信息
     *
     * @param userId 用户id
     * @param goodId 商品id
     * @throws SQLException              抛出异常
     * @throws InvocationTargetException 抛出异常
     * @throws IllegalAccessException    抛出异常
     */
    void createCart(int userId, String goodId) throws SQLException, InvocationTargetException, IllegalAccessException;

    /**
     * 查找购物车信息
     *
     * @param userId 用户id
     * @return 返回购物车集合
     * @throws SQLException              抛出异常
     * @throws InvocationTargetException 抛出异常
     * @throws IllegalAccessException    抛出异常
     */
    List<Cart> findCartById(int userId) throws SQLException, InvocationTargetException, IllegalAccessException;

    /**
     * 删除购物车信息
     *
     * @param cid 购物车id
     * @throws SQLException 抛出异常
     */
    void deleteCartByCid(String cid) throws SQLException;

    /**
     * 通过用户id删除购物车信息
     *
     * @param uid 用户id
     * @throws SQLException 抛出异常
     */
    void deleteCartByUid(int uid) throws SQLException;
}
