package com.qfedu.dao;

import com.qfedu.entity.Cart;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    /**
     * 通过用户id和商品id查询对应的购物车
     *
     * @param userId 用户id
     * @param goodId 商品id
     * @return 返回购物车类对象
     * @throws SQLException              sql异常
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException    抛出此异常
     */
    Cart hasCart(int userId, String goodId) throws SQLException, InvocationTargetException, IllegalAccessException;

    /**
     * 修改购物车
     *
     * @param cart 传入的购物车类对象
     * @throws SQLException 抛出sql异常
     */
    void updateCart(Cart cart) throws SQLException;

    /**
     * 插入购物车信息
     *
     * @param cart 传入的购物车类对象
     * @throws SQLException 抛出异常
     */
    void insertCart(Cart cart) throws SQLException;

    /**
     * 通过用户id查询所有的购物车信息
     *
     * @param userId 用户id
     * @return 返回此用户的所有购物车信息
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
     * 修改购物车信息
     *
     * @param cid    购物车id
     * @param newNum 商品数量
     * @param money  商品小计
     * @throws SQLException 抛出异常
     */
    void modifyByCid(String cid, int newNum, int money) throws SQLException;

    /**
     * 删除某个用户的所有购物车信息
     *
     * @param uid 用户id
     * @throws SQLException 抛出异常
     */
    void deleteCartByUid(int uid) throws SQLException;
}
