package com.fzc.fangzc.servlet;

import com.fzc.fangzc.Constant;
import com.fzc.fangzc.utils.RedisUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * SessionDemo1
 * <p>
 * Created by Administrator on 2017/10/30 0030.
 */
@WebServlet(
        name = "SessionDemo1",
        urlPatterns = {"/session", "/appointment/owner"},
        loadOnStartup = 1)
public class SessionDemo1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String cookie = null;

        Cookie[] cookies1 = request.getCookies();
        for (Cookie c : cookies1) {
            if (Constant.COOKIE.equals(c.getName())) {
                cookie = c.getValue();
                break;
            }
        }

        if (null != cookie) {
            System.out.println("已经登录，携带了cookie： " + cookie);
        } else {
            System.out.println("未登录");
        }


        String c = RedisUtils.getString(cookie);

        if (c == null) {
            System.out.println("携带的无效 cookie");
            return;
        }


        PrintWriter writer = response.getWriter();


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
