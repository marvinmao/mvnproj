package com.llnqdx.mvnproj.enjoy.spring02.servlet.sevlet;

import javax.servlet.*;
import java.io.IOException;

public class OrderFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        // 过滤请求
        System.out.println("UserFilter...doFilter...");
        //放行
        arg2.doFilter(arg0, arg1);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
