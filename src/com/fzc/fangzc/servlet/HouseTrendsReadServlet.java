package com.fzc.fangzc.servlet;

import com.fzc.fangzc.Constant;
import com.fzc.fangzc.entity.ApiMsg;
import com.fzc.fangzc.imp.HousesTrendsReadImpl;
import com.fzc.fangzc.utils.RedisUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HouseTrendsReadServlet
 * <p>
 * Created by Administrator on 2017/11/4 0004.
 */
@WebServlet(
        name = "HouseTrendsReadServlet",
        urlPatterns = {"/message/markRead"},
        loadOnStartup = 1)
public class HouseTrendsReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookie = null;

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (Constant.COOKIE.equals(c.getName())) {
                cookie = c.getValue();
                break;
            }
        }

        PrintWriter out = response.getWriter();

        if (null == cookie) {
            ApiMsg apiMsg = new ApiMsg(4000, "您还未登录！");
            out.write(new Gson().toJson(apiMsg));
            return;
        }

        String userId = RedisUtils.getString(cookie);
        if (userId == null) {
            ApiMsg apiMsg = new ApiMsg(4001, "登录异常！");
            out.write(new Gson().toJson(apiMsg));
            return;
        }

        String houseId = request.getParameter("messageId");
        HousesTrendsReadImpl readImpl = new HousesTrendsReadImpl();
        int result = readImpl.addHousesTrendsRead(Integer.valueOf(userId), Integer.valueOf(houseId));

        if (result == 0) {
            ApiMsg apiMsg = new ApiMsg(4003, "操作失败！");
            out.write(new Gson().toJson(apiMsg));
        } else {
            ApiMsg apiMsg = new ApiMsg(ApiMsg.OK, "操作成功！");
            out.write(new Gson().toJson(apiMsg));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
