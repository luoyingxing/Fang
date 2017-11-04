package com.fzc.fangzc.entity;

import java.io.Serializable;

/**
 * HousesTrends
 * <p>
 * Created by luoyingxing on 2017/7/9.
 */

public class HousesTrends implements Serializable {
    /**
     * id : 3
     * title : “双玺•时光道：中国意大利当代艺术双年展精品作品展”盛大启幕
     * content : 2017年7月1日，为期一个月的“双玺•时光道：深圳主义——中国意大利当代艺术双年展精品作品展”在深圳市南山区蛇口招商局广场27楼盛大开幕。
     * source : 新浪新闻
     * createTime : 2017-07-02 22:41:35
     */
    private int id;
    private int type;
    private String title;
    private String content;
    private String source;
    private String createTime;
    private boolean unread;

    public HousesTrends() {
    }

    public HousesTrends(int id, String title, String content, String source, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.source = source;
        this.createTime = createTime;
    }

    public HousesTrends(int id, String title, String content, String source, String createTime, boolean unread) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.source = source;
        this.createTime = createTime;
        this.unread = unread;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }
}
