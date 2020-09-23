package com.qfedu.dao.impl;

import com.qfedu.dao.AddressDao;
import com.qfedu.entity.Address;
import org.junit.Test;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl extends BaseDao implements AddressDao {
    @Override
    public List<Address> findAllByUid(int uid) throws SQLException {
        String sql = "select * from address where uid=?";
        return super.queryBeanList(sql, Address.class, uid);
    }

    @Override
    public Address findDefaultByUid(int uid) throws SQLException {
        String sql = "SELECT * FROM `address` WHERE uid=? AND `level`=1";
        return super.queryBean(sql, Address.class, uid);
    }

    @Override
    public void addAddress(Address address) {

    }

    @Override
    public void deleteAddress(String aid) {

    }

    @Override
    public void updateAddress(Address address) {

    }

    @Override
    public void updateLevel(String aid) {

    }


}
