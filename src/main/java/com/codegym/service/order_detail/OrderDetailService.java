package com.codegym.service.order_detail;

import com.codegym.dao.order.IOrderDao;
import com.codegym.dao.order.OrderDao;
import com.codegym.dao.order_detail.IOrderDetailDao;
import com.codegym.dao.order_detail.OrderDetailDao;
import com.codegym.dao.product.IProductDao;
import com.codegym.dao.product.ProductDao;
import com.codegym.model.*;

import java.util.List;

public class OrderDetailService implements IOrderDetailService {
    private IOrderDetailDao orderDetailDao = new OrderDetailDao();
    private IProductDao productDao = new ProductDao();
    private IOrderDao orderDao = new OrderDao();

    @Override
    public List<OrderDetail> getAll() {
        List<OrderDetail> orderDetails = orderDetailDao.getAll();
        for (OrderDetail orderDetail : orderDetails) {
            Orders orders = orderDao.findById(orderDetail.getOrder_id());
            orderDetail.setOrders(orders);
            Product product = productDao.findById(orderDetail.getProduct_id());
            orderDetail.setProduct(product);
        }
        return orderDetails;
    }

    @Override
    public boolean save(OrderDetail orderDetail) {
        return orderDetailDao.save(orderDetail);
    }

    @Override
    public boolean update(int id, OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return orderDetailDao.delete(id);
    }

    @Override
    public OrderDetail findById(int id) {
        OrderDetail orderDetail = orderDetailDao.findById(id);
        Product product = productDao.findById(orderDetail.getProduct_id());
        Orders orders = orderDao.findById(orderDetail.getOrder_id());
        orderDetail.setProduct(product);
        orderDetail.setOrders(orders);
        return orderDetail;
    }

    @Override
    public List<OrderDetail> findByAllId(int id) {
        List<OrderDetail> orderDetails = orderDetailDao.findByAllId(id);
        for (OrderDetail orderDetail : orderDetails) {
            Orders orders = orderDao.findById(orderDetail.getOrder_id());
            orderDetail.setOrders(orders);
            Product product = productDao.findById(orderDetail.getProduct_id());
            orderDetail.setProduct(product);
        }
        return orderDetails;
    }
}
