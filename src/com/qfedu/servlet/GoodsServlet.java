package com.qfedu.servlet;

import com.qfedu.entity.Goods;
import com.qfedu.entity.Goodstype;
import com.qfedu.entity.PageBean;
import com.qfedu.service.impl.GoodsServiceImpl;
import com.qfedu.service.impl.GoodsServiceImpl;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/goodsServlet")
public class GoodsServlet extends BaseServlet {
    private GoodsServiceImpl goodsServiceimpl = new GoodsServiceImpl();

    /**
     * 展示商品
     *
     * @param request  请求
     * @param response 响应
     */
    public void showGoodsServlet(HttpServletRequest request, HttpServletResponse response) {
        //获取商品类型id
        String goodsTypeId = request.getParameter("goodsTypeId");

//        当前页容量
        int pageSize = 8;

//        获取当前页数
        String currentPage = request.getParameter("currentPage");
        int page = 1;
        if (currentPage != null) {
            page = Integer.parseInt(currentPage);
        }

        PageBean<Goods> pageBean = null;
        try {
            pageBean = goodsServiceimpl.findPage(goodsTypeId, page, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pageBean", pageBean);
        try {
            request.getRequestDispatcher("goods.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 展示商品类别
     *
     * @param request  请求
     * @param response 响应
     */
    public void showGoodsDetailsServlet(HttpServletRequest request, HttpServletResponse response) {
//        获取商品id
        String goodsId = request.getParameter("goodsId");

//        通过商品id找到对应的商品信息
        Goods goods = goodsServiceimpl.findGoodsById(goodsId);

        request.setAttribute("goods", goods);
        try {
            request.getRequestDispatcher("goodsDetails.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
