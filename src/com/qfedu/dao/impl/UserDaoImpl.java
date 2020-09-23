package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.Address;
import com.qfedu.entity.User;
import org.apache.commons.beanutils.BeanUtils;
import util.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User findUserByUserName(String userName) {
        String sql = "select * from user where username = ?";
        User user = new User();
        Map<String, Object> map = null;
        try {
            map = super.queryMap(sql, userName);
            BeanUtils.populate(user, map);
        } catch (SQLException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByUserAndPd(String username, String password) throws SQLException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        String sql = "select * from user where username = ? and password = ?";

        Map<String, Object> map = super.queryMap(sql, username, password);
        BeanUtils.populate(user, map);

        return user;
    }

    @Override
    public int insertUser(User user) throws SQLException {
        String sql = "insert into user (username, password, email, gender, flag, role, code) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(),
        user.getFlag(), user.getRole(), user.getCode()};
        return super.update(sql, params);
    }

    @Override
    public List<Address> findAddressByUsername(String username) throws SQLException {
        String sql = "SELECT a.* FROM address a,`user` u WHERE a.uid=u.id AND u.username = ?";

        return super.queryBeanList(sql, Address.class, username);
    }


}
