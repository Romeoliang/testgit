package com.qfedu.service;

import com.qfedu.entity.Goods;
import com.qfedu.entity.Goodstype;
import com.qfedu.entity.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {

    /**
     * 查找所有商品类别
     *
     * @return 返回所有商品类别
     */
    List<Goodstype> findAllGoodsType();

    /**
     * 查找所有商品
     *
     * @return 返回所有商品
     */
    List<Goods> findAllGoods();

    /**
     * 通过商品类别查找对应的商品
     *
     * @param typeId 类别id
     * @return 返回此类别对应的商品
     */
    List<Goods> findAllGoodsByTypeId(String typeId);

    /**
     * 分页展示
     *
     * @param goodsTypeId 商品类别
     * @param currentPage 当前页数（第几页
     * @param pageSize    页容量
     * @return 返回此页展示商品
     * @throws SQLException 抛出异常
     */
    PageBean<Goods> findPage(String goodsTypeId, int currentPage, int pageSize) throws SQLException;


    /**
     * 查找商品
     *
     * @param goodsId 商品id
     * @return 返回此商品类对象
     */
    Goods findGoodsById(String goodsId);
}
