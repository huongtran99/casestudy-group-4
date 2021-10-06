package com.codegym.dao;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralDao<C> {
    List<C> getAll() ;

    boolean save(C c);

    boolean update(int id, C c);

    boolean delete(int id) ;

    C findById(int id) ;
}
