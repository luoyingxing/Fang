package com.fzc.fangzc.servlet;

import com.fzc.fangzc.Constant;
import com.fzc.fangzc.entity.ApiMsg;
import com.fzc.fangzc.entity.UserInfo;
import com.fzc.fangzc.imp.UserInfoDaoImpl;
import com.fzc.fangzc.utils.RedisUtils;
import com.fzc.fangzc.utils.TextUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * LoginServlet
 * <p>
 * Created by Administrator on 2017/11/1 0001.
 */
@WebServlet(
        name = "LoginServlet",
        urlPatterns = "/login",
        loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String phone = request.getParameter("account");
        String password = request.getParameter("password");

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            ApiMsg apiMsg = new ApiMsg(3002, "账户或者密码不能为空！");
            out.write(new Gson().toJson(apiMsg));
            return;
        }

        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        UserInfo userInfo = userInfoDao.findUserInfoByPhone(phone);

        if (userInfo == null) {
            ApiMsg apiMsg = new ApiMsg(3001, "该账户不存在，请先注册！");
            out.write(new Gson().toJson(apiMsg));
        } else {
            if (!password.equals(userInfo.getPassword())) {
                ApiMsg apiMsg = new ApiMsg(3003, "密码错误！");
                out.write(new Gson().toJson(apiMsg));
                return;
            }

            UserInfo user = new UserInfo(userInfo);

            String uid = UUID.randomUUID().toString();
            System.out.println("用户登录，生成Cookie: " + uid);
            Cookie cookie = new Cookie(Constant.COOKIE, uid);
            response.addCookie(cookie);

            //Content-Type application/x-www-form-urlencoded;charset=utf-8

            RedisUtils.setString(uid, String.valueOf(user.getId()));
            out.write(new Gson().toJson(user));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
    }

    @Override
    public void destroy() {
    }
}