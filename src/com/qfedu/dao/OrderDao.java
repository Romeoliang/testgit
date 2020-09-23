package com.qfedu.dao;

import com.qfedu.entity.Order;
import com.qfedu.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    /**
     * 插入订单
     *
     * @param order 订单类对象
     * @throws SQLException 抛出sql异常
     */
    void insertOrder(Order order) throws SQLException;

    /**
     * 插入订单详情
     *
     * @param details 订单详情List集合
     * @throws SQLException
     */
    void insertOrderDetail(List<OrderDetail> details) throws SQLException;
}
