package com.fzc.fangzc.imp;

import com.fzc.fangzc.dao.BaseDao;
import com.fzc.fangzc.dao.UserInfoDao;
import com.fzc.fangzc.entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDaoImpl
 * id,name,password,phone,age,address,email,tag
 * <p>
 * Created by Administrator on 2017/10/26 0026.
 */
public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

    @Override
    public int addUserInfo(UserInfo user) {
        return 0;
    }

    @Override
    public List<UserInfo> findUserInfoList() {
        return null;
    }

    @Override
    public UserInfo findUserInfoById(int id) {
        return null;
    }

    @Override
    public UserInfo findUserInfoByPhone(String phoneNumber) {
        String query = "select * from UserInfo where 1=1";
        List<Object> params = new ArrayList<>();
        query = query + " and phone = ?";
        params.add(phoneNumber);
        ResultSet rs = executeQuery(query, params);
        try {
            if (rs.next()) {
                //id,name,password,phone,age,address,email,tag
                int id = rs.getInt("id");
                String nickname = rs.getString("nickname");
                String realname = rs.getString("realname");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String avatar = rs.getString("avatar");
                int points = rs.getInt("points");
                String tags = rs.getString("tags");
                String sex = rs.getString("sex");
                String province = rs.getString("province");
                String city = rs.getString("city");
                String address = rs.getString("address");

                return new UserInfo(id, nickname, realname, phone, password, email, avatar, points, tags, sex, province, city, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    @Override
    public List<UserInfo> findUserInfoListByName(String name) {
        return null;
    }

    @Override
    public List<UserInfo> findUserInfoListByTag(String tag) {
        return null;
    }

    @Override
    public int deleteUserInfoById(int id) {
        return 0;
    }

    @Override
    public int updateUserInfoById(int id, UserInfo user) {
        return 0;
    }

    @Override
    public boolean checkUserInfoExist(String phone) {
        List<UserInfo> list = findUserInfoList();
        for (UserInfo user : list) {
            if (user.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}