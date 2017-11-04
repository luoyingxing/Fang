package com.fzc.fangzc.entity;

import java.io.Serializable;

/**
 * HousesTrends
 * <p>
 * Created by luoyingxing on 2017/7/9.
 */

public class HousesTrendsRead implements Serializable {
    private int id;
    private int userId;
    private int housesTrendsId;

    public HousesTrendsRead() {
    }

    public HousesTrendsRead(int id, int userId, int housesTrendsId) {
        this.id = id;
        this.userId = userId;
        this.housesTrendsId = housesTrendsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHousesTrendsId() {
        return housesTrendsId;
    }

    public void setHousesTrendsId(int housesTrendsId) {
        this.housesTrendsId = housesTrendsId;
    }
}
