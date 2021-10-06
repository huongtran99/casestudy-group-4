package com.codegym.service.product;

import com.codegym.dao.product.IProductDao;
import com.codegym.dao.product.ProductDao;
import com.codegym.model.Product;

import java.util.List;

public class ProductService implements IProductService{
    private IProductDao productDao = new ProductDao();

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public boolean edit(int id, Product product) {
        return productDao.edit(id,product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> findProductByCategoryId(int category_id) {
        return null;
    }

    @Override
    public boolean updateProductAmountAfterUserBuy(int id, int product_inventory) {
        return false;
    }
}
