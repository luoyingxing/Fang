package com.fzc.fangzc.dao;


import com.fzc.fangzc.entity.HousesTrends;

import java.util.List;

/**
 * HouseTrendsDao
 * <p>
 * Created by Administrator on 2017/11/4 0026.
 */
public interface HouseTrendsDao {
    int addHouseTrends(HousesTrends user);

    List<HousesTrends> findHousesTrendsList();

    HousesTrends findHousesTrendsById(int id);

    HousesTrends findHousesTrendsByPhone(String phone);

    List<HousesTrends> findHousesTrendsListByName(String name);

    List<HousesTrends> findHousesTrendsListByTag(String tag);

    int deleteHousesTrendsById(int id);

    int updateHousesTrendsById(int id, HousesTrends user);

    boolean checkHousesTrendsExist(String phone);
}