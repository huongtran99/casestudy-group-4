package com.codegym.service.order;

import com.codegym.dao.order.IOrderDao;
import com.codegym.dao.order.OrderDao;
import com.codegym.dao.user.IUserDao;
import com.codegym.dao.user.UserDao;
import com.codegym.model.Orders;
import com.codegym.model.User;

import java.util.List;

public class OrderService implements IOrderService{
    IOrderDao orderDao = new OrderDao();
    private IUserDao userDao = new UserDao();

    @Override
    public List<Orders> getAll() {
        List<Orders> orderList = orderDao.getAll();
        for (Orders order : orderList) {
            User user = userDao.findById(order.getUser_id());
            order.setUser(user);
        }
        return orderList;
    }

    @Override
    public boolean save(Orders orders) {
        return orderDao.save(orders);
    }

    @Override
    public boolean update(int id, Orders orders) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Orders findById(int id) {
        return orderDao.findById(id);
    }
}
