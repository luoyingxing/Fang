package com.fzc.fangzc.servlet;


import com.fzc.fangzc.entity.User;
import com.fzc.fangzc.imp.UserDaoImpl;
import com.fzc.fangzc.utils.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "AddUserServlet",
        urlPatterns = {"/user/add"},
        loadOnStartup = 1)
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String tag = request.getParameter("tag");

        boolean enableCommit = false;

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(age)
                || TextUtils.isEmpty(address) || TextUtils.isEmpty(email) || TextUtils.isEmpty(tag)) {
            enableCommit = false;
        } else {
            enableCommit = true;
            User user = new User(name, password, Integer.valueOf(age), phone, address, email, tag);
            UserDaoImpl userDao = new UserDaoImpl();
            int re = userDao.addUser(user);
            System.out.println(user.toString());
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("    <head>\r\n")
                .append("        <title>增加用户信息</title>\r\n")
                .append("    </head>\r\n")
                .append("    <body>\r\n")
                .append("            ").append(enableCommit ? "增加成功！" : "增加失败！信息不完整！")
                .append("            <br/><br/>\r\n")
                .append("        <form action=\"/hello/user/add\" method=\"POST\">\r\n")
                .append("            Enter your User info:<br/>\r\n")
                .append("            name: <input type=\"text\" name=\"name\"/><br/>\r\n")
                .append("            password: <input type=\"text\" name=\"password\"/><br/>\r\n")
                .append("            phone: <input type=\"text\" name=\"phone\"/><br/>\r\n")
                .append("            age: <input type=\"text\" name=\"age\"/><br/>\r\n")
                .append("            address: <input type=\"text\" name=\"address\"/><br/>\r\n")
                .append("            email: <input type=\"text\" name=\"email\"/><br/>\r\n")
                .append("            tag: <input type=\"text\" name=\"tag\"/><br/>\r\n")
                .append("            <input type=\"submit\" value=\"增加用户信息\"/>\r\n")
                .append("        </form>\r\n")
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