package com.qfedu.service.impl;

import com.qfedu.dao.impl.AddressDaoImpl;
import com.qfedu.entity.Address;
import com.qfedu.service.AddressService;
import org.junit.Test;

import java.sql.SQLException;

public class AddressServiceImpl implements AddressService {
    private AddressDaoImpl addressDao = new AddressDaoImpl();

    @Override
    public Address findDefaultByUid(int uid) {
        Address address = null;
        try {
            address = addressDao.findDefaultByUid(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

}
