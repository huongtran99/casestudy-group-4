package com.codegym.service.product;

import com.codegym.dao.brand.BrandDao;
import com.codegym.dao.brand.IBrandDao;
import com.codegym.dao.category.CategoryDao;
import com.codegym.dao.category.ICategoryDao;
import com.codegym.dao.product.IProductDao;
import com.codegym.dao.product.ProductDao;
import com.codegym.model.Brand;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public class ProductService implements IProductService {
    private IProductDao productDao = new ProductDao();
    private ICategoryDao categoryDao = new CategoryDao();
    private IBrandDao brandDao = new BrandDao();

    @Override
    public List<Product> getAll() {
        List<Product> products = productDao.getAll();
        for (Product product : products) {
            Category category = categoryDao.findById(product.getCategory_id());
            Brand brand = brandDao.findById(product.getBrand_id());
            product.setCategory(category);
            product.setBrand(brand);
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDao.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public Product findById(int id) {
        Product products = productDao.findById(id);
        Category category = categoryDao.findById(products.getCategory_id());
        Brand brand = brandDao.findById(products.getBrand_id());
        products.setCategory(category);
        products.setBrand(brand);
        return products;
    }



    @Override
    public List<Product> findProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> findProductByCategoryId(int categoryId) {
        return productDao.findProductByCategoryId(categoryId);
    }

    @Override
    public boolean updateProductAmountAfterUserBuy(int id, int product_inventory) {
        return false;
    }

    @Override
    public List<User> findUserByName(String user_name) {
        return productDao.findUserByName(user_name);
    }
}
