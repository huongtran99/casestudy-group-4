package com.codegym.dao.category;

import com.codegym.dao.DBConnection;
import com.codegym.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao {
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from category");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean save(Category category) {
        boolean isCreated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into category(category_name) value (?)");
            preparedStatement.setString(1, category.getCategory_name());
            isCreated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, Category category) {
        boolean isUpdated = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update category set category_name = ? where category_id =?");
            preparedStatement.setString(1, category.getCategory_name());
            preparedStatement.setInt(2,category.getCategory_id());
            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_category_by_id(?)");
            callableStatement.setInt(1, id);
            isDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from category where category_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("category_name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> findUserByName(String name) {
        return null;
    }
}
