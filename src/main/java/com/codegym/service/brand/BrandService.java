package com.codegym.service.brand;
import com.codegym.dao.brand.BrandDao;
import com.codegym.dao.brand.IBrandDao;
import com.codegym.model.Brand;

import java.util.List;

public class BrandService implements IBrandService {
    private IBrandDao brandDao = new BrandDao();

    @Override
    public List<Brand> getAll() {
        return brandDao.getAll();
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
        return null;
    }
}
