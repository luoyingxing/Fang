package com.fzc.fangzc.dao;

import com.fzc.fangzc.Constant;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseDao
 * <p>
 * Created by Administrator on 2017/10/26 0026.
 */
public class BaseDao {
    //数据库链接对象
    private java.sql.Connection mConnection;
    //数据库命令执行对象
    private PreparedStatement mStatement;
    //数据库返回结果
    private java.sql.ResultSet mResultSet;

    //静态代码块
    static {
        //1、加载驱动
        try {
            Class.forName(Constant.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2、创建连接
    private void getConnection() {
        if (mConnection == null) {
            try {
                mConnection = DriverManager.getConnection(Constant.DB_URL, Constant.DB_USER, Constant.DB_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //执行读操作方法
    public java.sql.ResultSet executeQuery(String query, List<Object> params) {
        getConnection();
        try {
            //3、创建命令执行对象
            mStatement = mConnection.prepareStatement(query);
            //4、执行
            if (params != null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    mStatement.setObject(i + 1, params.get(i));
                }
            }
            mResultSet = mStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mResultSet;
    }

    //执行写操作方法
    public int executeUpdate(String query, List<Object> params) {
        int result = 0;
        getConnection();
        try {
            //3、创建命令执行对象
            mStatement = mConnection.prepareStatement(query);
            //4、执行
            if (params != null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    mStatement.setObject(i + 1, params.get(i));
                }
            }
            //5、处理结果
            result = mStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6、释放资源
            this.close();
        }
        return result;
    }


    //关闭资源
    public void close() {
        try {
            if (mResultSet != null) {
                mResultSet.close();
                mResultSet = null;
            }
            if (mStatement != null) {
                mStatement.close();
                mStatement = null;
            }
            if (mConnection != null) {
                mConnection.close();
                mConnection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
