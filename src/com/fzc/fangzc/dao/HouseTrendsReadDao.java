package com.fzc.fangzc.dao;


import com.fzc.fangzc.entity.HousesTrendsRead;

import java.util.List;

/**
 * HouseTrendsReadDao
 * <p>
 * Created by Administrator on 2017/11/4 0026.
 */
public interface HouseTrendsReadDao {

    List<HousesTrendsRead> getListByUserId(String userId);

    int addHousesTrendsRead(int userId, int readId);
}