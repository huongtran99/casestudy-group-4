package com.codegym.dao.product;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.Product;

public interface IProductDao extends IGeneralDao<Product> {


    Product findByCategory(int category_id);

    Product findByName(String product_name);

    boolean updateProductAmountAfterUserBuy(int id, int product_inventory);


}
