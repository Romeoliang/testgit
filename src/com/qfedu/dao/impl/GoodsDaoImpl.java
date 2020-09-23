package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.entity.Goods;
import com.qfedu.entity.Goodstype;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public List<Goods> findAllGoods() throws SQLException {
        String sql = "select * from goods";

        return super.queryBeanList(sql, Goods.class);
    }

    @Override
    public List<Goodstype> findAllGoodstype() throws SQLException {
        String sql = "select * from goodstype";

        return super.queryBeanList(sql, Goodstype.class);
    }

    @Override
    public List<Goods> findGoodsByTypeId(String typeId) throws SQLException {
        String sql = "SELECT * FROM goods WHERE typeid = ?";
        return super.queryBeanList(sql, Goods.class, typeId);
    }

    @Override
    public List<Goods> findGoodsByPage(int currentPage, int pageSize, String goodsTypeId) {
        String sql = "SELECT g.* FROM goods g WHERE `typeid` = ? limit ?,?";
        Object[] params = {goodsTypeId, (currentPage - 1) * pageSize, pageSize};
        List<Goods> list = null;
        try {
            list = super.queryBeanList(sql, Goods.class, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Goods findGoodsById(String goodsId) throws SQLException {
        String sql = "select * from goods where id = ?";

        return super.queryBean(sql, Goods.class, goodsId);
    }


}
