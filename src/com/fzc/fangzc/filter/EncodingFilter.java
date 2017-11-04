package com.fzc.fangzc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * EncodingFilter
 * <p>
 * Created by Administrator on 2017/11/4 0004.
 */
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        //application/x-www-form-urlencoded;charset=utf-8
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        chain.doFilter(req, resp);//继续执行
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}