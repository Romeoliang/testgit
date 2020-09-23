package com.qfedu.dao;

import com.qfedu.entity.Address;
import com.qfedu.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


public interface UserDao {
    /**
     * 通过用户名在数据库中查找对应用户的信息
     *
     * @param userName 要查找的用户名
     * @return 返回一个存储用户所有信息的User类对象
     */
    User findUserByUserName(String userName);

    /**
     * 通过用户名的密码查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回查找道德用户信息
     * @throws SQLException              抛出异常
     * @throws InvocationTargetException 抛出异常
     * @throws IllegalAccessException    抛出异常
     */
    User findUserByUserAndPd(String username, String password) throws SQLException, InvocationTargetException, IllegalAccessException;


    /**
     * 插入用户信息
     *
     * @param user 要插入的User类对象
     * @return 返回值是对数据库影响的行数
     * @throws SQLException 抛出异常
     */
    int insertUser(User user) throws SQLException;


    /**
     * 通过用户名查找地址信息
     *
     * @param username 输入的用户名
     * @return 返回的地址list集合
     * @throws SQLException sql异常
     */
    List<Address> findAddressByUsername(String username) throws SQLException;


}
