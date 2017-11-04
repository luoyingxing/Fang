package com.fzc.fangzc.imp;

import com.fzc.fangzc.dao.BaseDao;
import com.fzc.fangzc.dao.HouseTrendsDao;
import com.fzc.fangzc.entity.HousesTrends;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * HousesTrendsDaoImpl
 * <p>
 * Created by Administrator on 2017/11/4 0004.
 */
public class HousesTrendsDaoImpl extends BaseDao implements HouseTrendsDao {

    @Override
    public int addHouseTrends(HousesTrends user) {
        return 0;
    }

    @Override
    public List<HousesTrends> findHousesTrendsList() {
        String query = "select * from housesTrends";
        ResultSet rs = executeQuery(query, null);

//        private int id;
//        private int type;
//        private String title;
//        private String content;
//        private String source;
//        private String createTime;
//        private boolean unread;

        List<HousesTrends> list = new ArrayList<>();

        try {
            while (rs.next()) {
                //id, title, content, source, createTime
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String source = rs.getString("source");
                String createTime = rs.getString("createTime");

                list.add(new HousesTrends(id, title, content, source, createTime, true));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
    }

    @Override
    public HousesTrends findHousesTrendsById(int id) {
        return null;
    }

    @Override
    public HousesTrends findHousesTrendsByPhone(String phone) {
        return null;
    }

    @Override
    public List<HousesTrends> findHousesTrendsListByName(String name) {
        return null;
    }

    @Override
    public List<HousesTrends> findHousesTrendsListByTag(String tag) {
        return null;
    }

    @Override
    public int deleteHousesTrendsById(int id) {
        return 0;
    }

    @Override
    public int updateHousesTrendsById(int id, HousesTrends user) {
        return 0;
    }

    @Override
    public boolean checkHousesTrendsExist(String phone) {
        return false;
    }
}
