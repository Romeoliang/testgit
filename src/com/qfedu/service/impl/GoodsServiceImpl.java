package com.qfedu.service.impl;

import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.entity.Goodstype;
import com.qfedu.entity.PageBean;
import com.qfedu.service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDaoImpl goodsDao = new GoodsDaoImpl();

    @Override
    public List<Goodstype> findAllGoodsType(){
        List<Goodstype> allGoodstype = null;
        try {
            allGoodstype = goodsDao.findAllGoodstype();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allGoodstype;
    }

    @Override
    public List<Goods> findAllGoods() {
        List<Goods> allGoods = null;
        try {
            allGoods = goodsDao.findAllGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allGoods;
    }

    @Override
    public List<Goods> findAllGoodsByTypeId(String typeId) {
        List<Goods> goods = null;
        try {
            goods = goodsDao.findGoodsByTypeId(typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public PageBean<Goods> findPage(String goodsTypeId, int currentPage, int pageSize) throws SQLException {
        List<Goods> goodsList = findAllGoodsByTypeId(goodsTypeId);
        int totalCount =  goodsList.size();
        List<Goods> list = goodsDao.findGoodsByPage(currentPage, pageSize, goodsTypeId);
        PageBean<Goods> pageBean = new PageBean<>(list, currentPage, pageSize, totalCount);
        return pageBean;
    }


    @Override
    public Goods findGoodsById(String goodsId) {
        Goods goods = null;
        try {
            goods = goodsDao.findGoodsById(goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }

}
