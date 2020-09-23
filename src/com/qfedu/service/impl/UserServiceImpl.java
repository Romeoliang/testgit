package com.qfedu.service.impl;

import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public User loginCheck(String username, String password) {
        User user = userDao.findUserByUserName(username);
        if (null != user && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }




    /**
     * 用于检查用户在数据库中是否存在
     *
     * @param username 要检测的用户
     * @return 在数据库中已存在返回true，不存在返回false
     */
    @Override
    public boolean checkUsername(String username) {
        User user = userDao.findUserByUserName(username);
        return null != user;
    }

    @Override
    public int addUser(User user) throws SQLException {
        int i = userDao.insertUser(user);
        return i;

    }


}
