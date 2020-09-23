package com.qfedu.servlet;

import com.qfedu.entity.Cart;
import com.qfedu.entity.User;
import com.qfedu.service.impl.CartServiceImpl;
import com.qfedu.service.impl.GoodsServiceImpl;
import com.qfedu.service.impl.GoodsServiceImpl;
import org.junit.Test;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends BaseServlet {

    private CartServiceImpl cartService = new CartServiceImpl();
    private GoodsServiceImpl goodsService = new GoodsServiceImpl();

    /**
     * 跳转到购物车
     *
     * @param request  请求
     * @param response 响应
     */
    public void gotoCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

//        判断用户是否登录
        if (null == user) {
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("cart.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * 添加购物车
     *
     * @param request  请求
     * @param response 响应
     */
    public void addCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

//        判断用户是否登录
        if (null == user) {
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int userId = user.getId();
            String goodId = request.getParameter("goodId");

            try {
                cartService.createCart(userId, goodId);
                response.sendRedirect("cart?method=showCart");

            } catch (SQLException | InvocationTargetException | IllegalAccessException | IOException e) {
                e.printStackTrace();
            }


        }


    }

    /**
     * 展示购物车
     *
     * @param request  请求
     * @param response 响应
     */
    public void showCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        //        判断用户是否登录
        if (null == user) {
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<Cart> cartList = cartService.findCartById(user.getId());
                request.setAttribute("cartList", cartList);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            } catch (SQLException | InvocationTargetException | IllegalAccessException | ServletException | IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 修改
     *
     * @param request  请求
     * @param response 响应
     */
    public void modify(HttpServletRequest request, HttpServletResponse response) {
        String cid = request.getParameter("cid");
        String price = request.getParameter("price");
        String num = request.getParameter("num");

        try {
            cartService.modifyCartByCid(cid, price, num);
            response.sendRedirect("cart?method=showCart");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     *
     * @param request  请求
     * @param response 响应
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String cid = request.getParameter("cid");

        try {
            cartService.deleteCartByCid(cid);
            response.sendRedirect("cart?method=showCart");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 清空购物车
     *
     * @param request  qq
     * @param response 响应
     */
    public void clearCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        try {
            cartService.deleteCartByUid(user.getId());
            response.sendRedirect("cart?method=showCart");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
