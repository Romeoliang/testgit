package com.qfedu.dao;

import com.qfedu.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    /**
     * 通过用户id查询所有的地址
     *
     * @param uid 需要查询的用户
     * @return 返回此用户的所有地址信息
     * @throws SQLException 抛出异常
     */
    List<Address> findAllByUid(int uid) throws SQLException;

    /**
     * 通过用户id查询此用户的默认地址
     *
     * @param uid 需要查询的用户
     * @return 返回此用户的默认地址
     * @throws SQLException 抛出异常
     */
    Address findDefaultByUid(int uid) throws SQLException;

    /**
     * 添加地址
     *
     * @param address 传入的地址类对象
     */
    void addAddress(Address address);

    /**
     * 通过aid删除地址
     *
     * @param aid 传入的地址id
     */
    void deleteAddress(String aid);

    /**
     * 修改地址
     *
     * @param address 传入的地址类对象
     */
    void updateAddress(Address address);

    /**
     * 修改默认地址
     *
     * @param aid 传入的地址id
     */
    void updateLevel(String aid);


}
