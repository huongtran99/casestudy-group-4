package com.codegym.dao.user;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.User;

import java.util.List;

public interface IUserDao extends IGeneralDao<User> {

    User findByUserNameAndPassword(String user_name, String password);

    List<User> findUserByName(String name);

    User getUserDefaultDao();
}
