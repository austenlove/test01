package org.zerock.test01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class UTF8Filter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("UTF-8 Filter");

        HttpServletRequest req = (HttpServletRequest) request;

        req.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}
