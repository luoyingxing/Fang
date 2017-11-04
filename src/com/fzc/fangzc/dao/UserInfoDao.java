package com.fzc.fangzc.dao;

import com.fzc.fangzc.entity.UserInfo;

import java.util.List;

/**
 * UserInfoDao
 * <p>
 * Created by Administrator on 2017/10/26 0026.
 */
public interface UserInfoDao {
    int addUserInfo(UserInfo user);

    List<UserInfo> findUserInfoList();

    UserInfo findUserInfoById(int id);

    UserInfo findUserInfoByPhone(String phone);

    List<UserInfo> findUserInfoListByName(String name);

    List<UserInfo> findUserInfoListByTag(String tag);

    int deleteUserInfoById(int id);

    int updateUserInfoById(int id, UserInfo user);

    boolean checkUserInfoExist(String phone);
}