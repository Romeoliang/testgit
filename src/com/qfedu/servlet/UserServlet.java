package com.qfedu.servlet;

import com.qfedu.entity.User;
import com.qfedu.service.impl.UserServiceImpl;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    /**
     * 用户登录
     *
     * @param request  请求
     * @param response 响应
     */
    public void loginServlet(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto = request.getParameter("auto");
        User user = null;

        user = userService.loginCheck(username, password);

        if (null != user) {
            HttpSession session = request.getSession(true);

            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60 * 60 * 24 * 14);

            if (auto == null) {
//                清空cookie
                Cookie cookie = new Cookie("autoUser", "");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            } else {
                String content = username + ":" + password;
                Cookie cookie = new Cookie("autoUser", content);

                cookie.setMaxAge(60 * 60 * 24 * 14);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            try {
                response.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 用户退出
     *
     * @param request  请求
     * @param response 响应
     */
    public void logoutServlet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        session.invalidate();

        Cookie cookie = new Cookie("autoUser", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户注册
     *
     * @param request  请求
     * @param response 响应
     */
    public void registerServlet(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String againPassword = request.getParameter("againPassword");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        if (!password.equals(againPassword)) {
            request.setAttribute("result", false);
            try {
                request.getRequestDispatcher("signInStudent.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setGender(gender);

            try {
                userService.addUser(user);
                request.setAttribute("result", true);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } catch (SQLException | ServletException | IOException e) {
                e.printStackTrace();
            }

        }


    }
}
