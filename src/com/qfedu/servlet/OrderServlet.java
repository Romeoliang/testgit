package com.qfedu.servlet;

import com.qfedu.entity.Address;
import com.qfedu.entity.Cart;
import com.qfedu.entity.User;
import com.qfedu.service.impl.AddressServiceImpl;
import com.qfedu.service.impl.CartServiceImpl;
import com.qfedu.service.impl.OrderServiceImpl;
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

@WebServlet("/order")
public class OrderServlet extends BaseServlet {
    private CartServiceImpl cartService = new CartServiceImpl();
    private AddressServiceImpl addressService = new AddressServiceImpl();
    private OrderServiceImpl orderService = new OrderServiceImpl();

    /**
     * 提交订单
     *
     * @param request  请求
     * @param response 响应
     */
    public void submitOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        Address defaultAddress = addressService.findDefaultByUid(user.getId());


        try {
            List<Cart> cartList = cartService.findCartById(user.getId());
            request.setAttribute("cartList", cartList);
            request.setAttribute("defaultAddress", defaultAddress);
            request.getRequestDispatcher("submitOrder.jsp").forward(request, response);
        } catch (SQLException | InvocationTargetException | IllegalAccessException | ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加订单
     *
     * @param request  请求
     * @param response 响应
     */
    public void addOrder(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        String aid = request.getParameter("aid");
        String money = request.getParameter("money");

        try {
            orderService.createOrder(uid, aid, money);
            response.sendRedirect("pay.jsp");

        } catch (IllegalAccessException | SQLException | InvocationTargetException | IOException e) {
            e.printStackTrace();
        }
    }
}
