package com.qfedu.service;

import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface UserService {
    /**
     * 用于登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回用户类对象
     */
    User loginCheck(String username, String password);



    /**
     * 用于检查用户在数据库中是否存在
     *
     * @param username 要检测的用户
     * @return 在数据库中已存在返回true，不存在返回false
     */
    boolean checkUsername(String username);

    /**
     * 添加用户
     * @param user 用户类对象
     * @return 返回数据库受影响行数
     * @throws SQLException 抛出异常
     */
    int addUser(User user) throws SQLException;

}
