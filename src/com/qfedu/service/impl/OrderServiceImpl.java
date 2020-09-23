package com.qfedu.service.impl;

import com.qfedu.dao.CartDao;
import com.qfedu.dao.OrderDao;
import com.qfedu.dao.impl.CartDaoImpl;
import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.Cart;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderDetail;
import com.qfedu.service.OrderService;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private CartDao cartDao = new CartDaoImpl();


    @Override
    public void createOrder(String uid, String aid, String money) throws IllegalAccessException, SQLException, InvocationTargetException {
        Order order = new Order();
        String date = new SimpleDateFormat("yyyy/MM/dd|HH:mm:ss").format(new Date());
        String oid = date+ String.valueOf(Math.random());

        order.setOid(oid);
        order.setAid(Integer.parseInt(aid));
        order.setMoney(Double.parseDouble(money));
        order.setUid(Integer.parseInt(uid));
        order.setTime(date);
        order.setStatus(0);
        orderDao.insertOrder(order);

//        将购物车转为订单详情
        List<Cart> cartList = cartDao.findCartById(Integer.parseInt(uid));
        List<OrderDetail> details = new ArrayList<>();

        for (Cart cart : cartList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOid(oid);
            orderDetail.setPid(cart.getPid());
            orderDetail.setNum(cart.getNum());
            orderDetail.setMoney(cart.getMoney());
            details.add(orderDetail);
        }
        orderDao.insertOrderDetail(details);

//        清空购物车
        cartDao.deleteCartByUid(Integer.parseInt(uid));

    }
}
