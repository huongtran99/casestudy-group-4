package com.codegym.dao.brand;

import com.codegym.dao.DBConnection;
import com.codegym.model.Brand;
import com.codegym.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDao implements IBrandDao {
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Brand> getAll() {
        List<Brand> brandList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from brand");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("brand_id");
                String name = resultSet.getString("brand_name");
                Brand brand = new Brand(id, name);
                brandList.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandList;
    }

    @Override
    public boolean save(Brand brand) {
        return false;
    }

    @Override
    public boolean update(int id, Brand brand) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Brand findById(int id) {
        Brand brand = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM brand where brand_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("brand_name");
                brand = new Brand(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }
}
