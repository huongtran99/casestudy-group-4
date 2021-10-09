package com.codegym.dao.order_detail;

import com.codegym.dao.DBConnection;
import com.codegym.model.OrderDetail;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao implements IOrderDetailDao {
    Connection connection = DBConnection.getConnection();

    @Override
    public List<OrderDetail> getAll() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from order_detail");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int order_detail_id = resultSet.getInt("order_detail_id");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                int order_id = resultSet.getInt("order_id");
                int product_id = resultSet.getInt("product_id");
                OrderDetail orderDetail = new OrderDetail(order_detail_id, quantity, price, order_id, product_id);
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public boolean save(OrderDetail orderDetail) {
        boolean isCreated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into order_detail(quantity, price, order_id, product_id) value (?,?,?,?)");
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setDouble(2, orderDetail.getPrice());
            preparedStatement.setInt(3, orderDetail.getOrder_id());
            preparedStatement.setInt(4, orderDetail.getProduct_id());
            isCreated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from order_detail where order_detail_id=?");
            statement.setInt(1, id);
            isDelete = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    @Override
    public OrderDetail findById(int id) {
        OrderDetail orderDetail = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from order_detail where order_detail_id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int order_detail_id = resultSet.getInt("order_detail_id");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                int order_id = resultSet.getInt("order_id");
                int product_id = resultSet.getInt("product_id");
                orderDetail = new OrderDetail(order_detail_id,quantity,price,order_id,product_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetail;
    }

    @Override
    public List<OrderDetail> findByAllId(int id) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select order_detail.order_detail_id, order_detail.quantity, order_detail.price, order_detail.order_id, order_detail.product_id from order_detail join orders on order_detail.order_id = orders.order_id where orders.user_id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int order_detail_id = resultSet.getInt("order_detail_id");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                int order_id = resultSet.getInt("order_id");
                int product_id = resultSet.getInt("product_id");
                OrderDetail orderDetail = new OrderDetail(order_detail_id, quantity, price, order_id, product_id);
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
}
