package com.qfedu.filter;

import com.qfedu.entity.User;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login.html")
public class BAutoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            String content = null;

            for (Cookie cookie : cookies) {
//                如果找到自动登录存储的cookie名字就拿出来
                if ("autoUser".equals(cookie.getName())) {
                    content = cookie.getValue();
                }
            }
//            就算拿到了cookie里面的数据也可能是空的,需要判断
            if (content != null) {
                String[] split = content.split(":");
                String username = split[0];
                String password = split[1];

                UserServiceImpl userService = new UserServiceImpl();
                User user = userService.loginCheck(username, password);

//                判断用户名密码是否正确
                if (user != null) {
                    HttpSession session = request.getSession(true);

                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(60 * 60 * 24 * 14);
                    response.sendRedirect("index.jsp");

                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }



        } else {
//            没有cookie直接放行
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
