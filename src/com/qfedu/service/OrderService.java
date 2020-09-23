package com.qfedu.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface OrderService {
    /**
     * 创建订单
     *
     * @param uid   用户id
     * @param aid   地址id
     * @param money 总价格
     * @throws IllegalAccessException    抛出异常
     * @throws SQLException              抛出异常
     * @throws InvocationTargetException 抛出异常
     */
    void createOrder(String uid, String aid, String money) throws IllegalAccessException, SQLException, InvocationTargetException;
}
