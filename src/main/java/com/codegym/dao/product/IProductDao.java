package com.codegym.dao.product;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {

    List<Product> findProductByCategoryId(int categoryId);

    boolean updateProductAmountAfterUserBuy(int id, int product_inventory);

    List<User> findUserByName(String name);

}
