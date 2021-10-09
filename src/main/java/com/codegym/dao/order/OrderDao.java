package com.codegym.dao.order;

import com.codegym.dao.DBConnection;
import com.codegym.model.OrderDetail;
import com.codegym.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao{
    private Connection connection = DBConnection.getConnection();
    @Override
    public List<Orders> getAll() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from orders");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                String name = resultSet.getString("customer_name");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String discount = resultSet.getString("discount_code");
                int userId = resultSet.getInt("user_id");
                Orders order = new Orders(order_id, name, phone, email, discount,userId);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean save(Orders orders) {
        boolean isCreated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into orders(order_id, customer_name, customer_phone, customer_email, discount_code, user_id) value (?,?,?,?,?,?)");
            preparedStatement.setInt(1, orders.getOrder_id());
            preparedStatement.setString(2, orders.getCustomer_name());
            preparedStatement.setString(3, orders.getCustomer_phone());
            preparedStatement.setString(4, orders.getCustomer_email());
            preparedStatement.setString(5, orders.getDiscount_code());
            preparedStatement.setInt(6, orders.getUser_id());
            isCreated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
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
        Orders order = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from orders where order_id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String discount_code = resultSet.getString("discount_code");
                order = new Orders(order_id,customer_name,customer_phone,customer_email,discount_code);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
}
