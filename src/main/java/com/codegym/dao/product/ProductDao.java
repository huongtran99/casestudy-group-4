package com.codegym.dao.product;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {

    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select  * from product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                String product_code = resultSet.getString("product_code");
                String description = resultSet.getString("description");
                double product_price = resultSet.getDouble("product_price");
                String product_image = resultSet.getString("product_image");
                int product_inventory = resultSet.getInt("product_inventory");
                int category_id = resultSet.getInt("category_id");
                int brand_id = resultSet.getInt("brand_id");
                Product product = new Product(product_id, product_name, product_code, description, product_price, product_image, product_inventory, category_id, brand_id);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        boolean isInsert =false;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into product(product_name,product_code,description,product_price, product_image,product_inventory,category_id,brand_id) value (?,?,?,?,?,?,?,?)");
            statement.setString(1, product.getProduct_name());
            statement.setString(2, product.getProduct_code());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getProduct_price());
            statement.setString(5, product.getProduct_image());
            statement.setInt(6, product.getProduct_inventory());
            statement.setInt(7, product.getCategory_id());
            statement.setInt(8, product.getBrand_id());
            isInsert = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean isEdit = false;
        try {
            PreparedStatement statement = connection.prepareStatement("update product set product_name = ?, product_code = ?, description = ?, product_price = ?, product_image = ?, product_inventory = ?, category_id=?, brand_id=? where  product_id = ?");
            statement.setString(1,product.getProduct_name());
            statement.setString(2, product.getProduct_code());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getProduct_price());
            statement.setString(5, product.getProduct_image());
            statement.setInt(6, product.getProduct_inventory());
            statement.setInt(7, product.getCategory_id());
            statement.setInt(8, product.getBrand_id());
            statement.setInt(9,product.getProduct_id());
            isEdit = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isEdit;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from product where product_id=?");
            statement.setInt(1, id);
            isDelete = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product where product_id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                String product_code = resultSet.getString("product_code");
                String description = resultSet.getString("description");
                double product_price = resultSet.getDouble("product_price");
                String product_image = resultSet.getString("product_image");
                int product_inventory = resultSet.getInt("product_inventory");
                int category_id = resultSet.getInt("category_id");
                int brand_id = resultSet.getInt("brand_id");
                product = new Product(product_id,product_name,product_code,description,product_price,product_image,product_inventory,category_id,brand_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product findByCategory(int category_id) {
        return null;
    }

    @Override
    public Product findByName(String product_name) {
        return null;
    }

    @Override
    public boolean updateProductAmountAfterUserBuy(int id, int product_inventory) {
        return false;
    }
}
