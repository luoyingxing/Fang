package com.fzc.fangzc.imp;

import com.fzc.fangzc.dao.BaseDao;
import com.fzc.fangzc.dao.UserDao;
import com.fzc.fangzc.entity.User;

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
public class UserDaoImpl extends BaseDao implements UserDao {

    //添加一条用户信息
    @Override
    public int addUser(User user) {
        String update = "insert into user(name,password,phone,age,address,email,tag)values(?,?,?,?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(user.getName());
        params.add(user.getPassword());
        params.add(user.getPhone());
        params.add(user.getAge());
        params.add(user.getAddress());
        params.add(user.getEmail());
        params.add(user.getTag());
        return executeUpdate(update, params);
    }

    @Override
    public List<User> findUsers() {
        List<User> list = new ArrayList<>();
        String query = "select * from user";
        ResultSet rs = executeQuery(query, null);
        try {
            while (rs.next()) {
                //id,name,password,phone,age,address,email,tag
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String tag = rs.getString("tag");

                User user = new User(id, name, password, age, phone, address, email, tag);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return list;
    }

    @Override
    public User findUserById(int id) {
        String query = "select * from user where 1=1";
        List<Object> params = new ArrayList<>();
        query = query + " and id = ?";
        params.add(id);
        ResultSet rs = executeQuery(query, params);
        try {
            if (rs.next()) {
                //id,name,password,phone,age,address,email,tag
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String tag = rs.getString("tag");

                return new User(id, name, password, age, phone, address, email, tag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }

    @Override
    public List<User> findUsersByName(String nameString) {
        String query = "select * from user where ";
        List<Object> params = new ArrayList<>();
        if (nameString != null && !"".equals(nameString)) {
            query = query + " name like ?";
            params.add("%" + nameString + "%");
        }
        List<User> list = new ArrayList<>();
        ResultSet rs = executeQuery(query, params);
        try {
            while (rs.next()) {
                //id,name,password,phone,age,address,email,tag
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String tag = rs.getString("tag");

                User user = new User(id, name, password, age, phone, address, email, tag);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return list;
    }

    @Override
    public List<User> findUsersByTag(String tag) {
        List<User> list = new ArrayList<>();
        String query = "select * from user where tag = '" + tag + "'";
        ResultSet rs = executeQuery(query, null);
        try {
            while (rs.next()) {
                //id,name,password,phone,age,address,email,tag
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String tags = rs.getString("tag");

                User user = new User(id, name, password, age, phone, address, email, tags);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return list;
    }

    @Override
    public int deleteUserById(int id) {
        String query = "delete from user where id = ?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        return executeUpdate(query, params);
    }

    @Override
    public int updateUserById(int id, User role) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean checkUserExist(String phone) {
        List<User> list = findUsers();
        for (User user : list) {
            if (user.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

}

