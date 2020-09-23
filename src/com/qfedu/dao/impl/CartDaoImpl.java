package com.qfedu.dao.impl;

import com.qfedu.dao.CartDao;
import com.qfedu.entity.Cart;
import com.qfedu.entity.Goods;
import org.apache.commons.beanutils.BeanUtils;
import util.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoImpl extends BaseDao implements CartDao {

    @Override
    public Cart hasCart(int userId, String goodId) throws SQLException, InvocationTargetException, IllegalAccessException {
        String sql = "select * from cart c,goods g where g.id=c.pid and uid=? and pid=?";

        Map<String, Object> map = queryMap(sql, userId, goodId);

        if (map == null) {
            return null;
        }

        Cart cart = new Cart();
        Goods goods = new Goods();
        BeanUtils.populate(cart, map);
        BeanUtils.populate(goods, map);
        cart.setGoods(goods);
        return cart;
    }

    @Override
    public void updateCart(Cart cart) throws SQLException {
        String sql = "update cart set num=?,money=? where uid=? and pid=?";

        Object[] params = {cart.getNum(), cart.getMoney(), cart.getUid(), cart.getPid()};

        super.update(sql, params);
    }

    @Override
    public void insertCart(Cart cart) throws SQLException {
        String sql = "insert into cart (uid, pid, num, money) VALUES (?, ?, ?, ?)";
        Object[] params = {cart.getUid(), cart.getPid(), cart.getNum(), cart.getMoney()};

        super.update(sql, params);
    }

    @Override
    public List<Cart> findCartById(int userId) throws SQLException, InvocationTargetException, IllegalAccessException {
        String sql = "select * from cart c,goods g where c.pid=g.id and c.uid=?";

        List<Map<String, Object>> maps = super.queryMapList(sql, userId);
        if (maps == null) {
            return null;
        }

        List<Cart> carts = new ArrayList<>();

        for (Map<String, Object> map : maps) {
            Cart cart = new Cart();
            Goods goods = new Goods();
            BeanUtils.populate(cart, map);
            BeanUtils.populate(goods, map);
            cart.setGoods(goods);
            carts.add(cart);
        }
        return carts;
    }

    @Override
    public void deleteCartByCid(String cid) throws SQLException {
        String sql = "delete from cart where cid=?";
        super.update(sql, cid);
    }

    @Override
    public void modifyByCid(String cid, int newNum, int money) throws SQLException {
        String sql = "update cart set num=?,money=? where cid=?";

        super.update(sql, newNum, money, cid);
    }

    @Override
    public void deleteCartByUid(int uid) throws SQLException {
        String sql = "delete from cart where uid=?";

        super.update(sql, uid);
    }
}
