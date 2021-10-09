package com.codegym.controller;

import com.codegym.dao.user.UserDao;
import com.codegym.model.OrderDetail;
import com.codegym.model.Orders;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.brand.BrandService;
import com.codegym.service.brand.IBrandService;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.order.IOrderService;
import com.codegym.service.order.OrderService;
import com.codegym.service.order_detail.IOrderDetailService;
import com.codegym.service.order_detail.OrderDetailService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();
    private IBrandService brandService = new BrandService();
    private IOrderService orderService = new OrderService();
    private IOrderDetailService orderDetailService = new OrderDetailService();
    private IUserService userService = new UserService();
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "buy": {

                break;
            }
            default: {
                showOrder(request, response);
                break;
            }
        }
    }

    private void showOrder(HttpServletRequest request, HttpServletResponse response) {
        User user = userDao.user;
        List<OrderDetail> orderDetails = orderDetailService.findByAllId(user.getUser_id());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/orders/checkout.jsp");
        request.setAttribute("orderDetails", orderDetails);
        request.setAttribute("user", user);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "buy": {
                checkOut(request, response);
                break;
            }
            case "buynow": {
                buyNow(request, response);
                break;
            }
            case "order": {
                order(request, response);
                break;
            }
        }
    }

    private void order(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        orderDetailService.delete(id);
        try {
            response.sendRedirect("/order");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buyNow(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.findById(productId);
        int idDetailO = Integer.parseInt(request.getParameter("idDetailO"));
        User user = userDao.user;
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder_detail_id(idDetailO);
        orderDetail.setQuantity(quantity);
        orderDetail.setPrice(quantity * product.getProduct_price());
        orderDetail.setProduct(product);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/orders/buy.jsp");
        request.setAttribute("orderDetails", orderDetail);
        request.setAttribute("user", user);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void checkOut(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.findById(productId);
        User user = userDao.user;
        List<Orders> orders = orderService.getAll();
        int orderId = orders.size();
        Orders order = new Orders(orderId + 1, user.getUser_name(), user.getPhone(), user.getEmail(), "", user.getUser_id());
        orderService.save(order);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(quantity);
        orderDetail.setPrice(quantity * product.getProduct_price());
        orderDetail.setOrder_id(order.getOrder_id());
        orderDetail.setProduct_id(product.getProduct_id());
        boolean isBuy = orderDetailService.save(orderDetail);
        List<OrderDetail> orderDetailList = orderDetailService.getAll();
        OrderDetail orderDetails = orderDetailService.findById(orderDetailList.size());
        RequestDispatcher dispatcher;
        if (!isBuy) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/orders/buy.jsp");
            request.setAttribute("orderDetails", orderDetails);
            request.setAttribute("user", user);

        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
