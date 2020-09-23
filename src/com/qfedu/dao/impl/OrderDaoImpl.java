package com.qfedu.dao.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderDetail;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public void insertOrder(Order order) throws SQLException {
        String sql = "insert into `order` (oid, uid, money, status, time, aid) VALUES (?,?,?,?,?,?)";
        Object[] params = {order.getOid(), order.getUid(), order.getMoney(), order.getStatus(), order.getTime(), order.getAid()};

        super.update(sql, params);

    }

    @Override
    public void insertOrderDetail(List<OrderDetail> details) throws SQLException {
        String sql = "insert into orderdetail(pid, oid, num, money) VALUES (?,?,?,?)";
        for (OrderDetail detail : details) {
            Object[] params = {detail.getPid(), detail.getOid(), detail.getNum(), detail.getMoney()};
            super.update(sql, params);
        }
    }
}
