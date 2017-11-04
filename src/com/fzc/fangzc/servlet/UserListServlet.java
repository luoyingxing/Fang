package com.fzc.fangzc.servlet;

import com.fzc.fangzc.entity.User;
import com.fzc.fangzc.imp.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "UserListServlet",
        urlPatterns = {"/user/list"},
        loadOnStartup = 1)
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDaoImpl userDao = new UserDaoImpl();
        List<User> list = userDao.findUsersByName("六");

        PrintWriter writer = response.getWriter();

        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("    <head>\r\n")
                .append("        <title>查询用户信息</title>\r\n")
                .append("    </head>\r\n");

        for (User user : list) {
            writer.append("<br>").append(user.toString()).append("<br/>").append("\r\n");
        }

        writer.append("    <body>\r\n")
                .append("            <br/><br/>\r\n")
                .append("    </body>\r\n")
                .append("</html>\r\n");
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