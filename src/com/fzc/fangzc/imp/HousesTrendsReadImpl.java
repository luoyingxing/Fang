package com.fzc.fangzc.imp;

import com.fzc.fangzc.dao.BaseDao;
import com.fzc.fangzc.dao.HouseTrendsReadDao;
import com.fzc.fangzc.entity.HousesTrendsRead;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * HousesTrendsReadImpl
 * <p>
 * Created by Administrator on 2017/11/4 0004.
 */
public class HousesTrendsReadImpl extends BaseDao implements HouseTrendsReadDao {

    @Override
    public List<HousesTrendsRead> getListByUserId(String userIdStr) {
        String query = "select * from housesTrendsRead where 1=1 ";
        List<Object> params = new ArrayList<>();
        query = query + " and userId = ?";
        params.add(userIdStr);
        ResultSet rs = executeQuery(query, params);

        List<HousesTrendsRead> list = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("userId");
                int housesTrendsId = rs.getInt("housesTrendsId");
                list.add(new HousesTrendsRead(id, userId, housesTrendsId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
    }


    @Override
    public int addHousesTrendsRead(int userId, int readId) {
        String update = "insert into housesTrendsRead(userId,housesTrendsId)values(?,?)";
        List<Object> params = new ArrayList<>();
        params.add(userId);
        params.add(readId);
        return executeUpdate(update, params);
    }
}
