package com.codegym.dao;

import com.codegym.model.Product;

import java.util.List;

public interface IGeneralDao<T> {
    List<T> getAll();

    boolean insert(T t);

    boolean edit(int id,T t);

    boolean delete (int id );

    T findById(int id);

}
