package com.codegym.dao.user_role;

import com.codegym.dao.DBConnection;
import com.codegym.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDao implements IUserRoleDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<UserRole> getAll() {
        return null;
    }

    @Override
    public boolean save(UserRole userRole) {
        return false;
    }

    @Override
    public boolean update(int id, UserRole userRole) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public UserRole findById(int id) {
        return null;
    }

}
