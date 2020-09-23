package com.qfedu.dao;

import com.qfedu.entity.Goods;
import com.qfedu.entity.Goodstype;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    /**
     * 查询所有商品
     *
     * @return 返回所有的商品信息
     * @throws SQLException 抛出异常
     */
    List<Goods> findAllGoods() throws SQLException;

    /**
     * 查询所有的商品类别
     *
     * @return 返回所有的商品类别
     * @throws SQLException
     */
    List<Goodstype> findAllGoodstype() throws SQLException;

    /**
     * 根据商品类型名字查找所有此类型的商品
     *
     * @param typeId 商品类型id
     * @return 返回所有此类型的商品的集合
     * @throws SQLException sql异常
     */
    List<Goods> findGoodsByTypeId(String typeId) throws SQLException;

    /**
     * 分页展示商品
     *
     * @param currentPage 当前页数（第几页）
     * @param pageSize    页容量
     * @param goodsType   商品类别
     * @return 返回此页的所有商品
     */
    List<Goods> findGoodsByPage(int currentPage, int pageSize, String goodsType);

    /**
     * 通过商品id查找商品信息
     *
     * @param goodsId 商品id
     * @return 返回商品信息
     * @throws SQLException 抛出sql异常
     */
    Goods findGoodsById(String goodsId) throws SQLException;
}
