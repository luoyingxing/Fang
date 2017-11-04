package com.fzc.fangzc.dao;

import com.fzc.fangzc.entity.User;

import java.util.List;

/**
 * UserDao
 * <p>
 * Created by Administrator on 2017/10/26 0026.
 */
public interface UserDao {
    int addUser(User user);

    List<User> findUsers();

    User findUserById(int id);

    List<User> findUsersByName(String name);

    List<User> findUsersByTag(String tag);

    int deleteUserById(int id);

    int updateUserById(int id, User user);

    boolean checkUserExist(String phone);
}