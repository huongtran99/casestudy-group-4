package com.codegym.service.user;

import com.codegym.dao.user.IUserDao;
import com.codegym.dao.user.UserDao;
import com.codegym.model.User;

import java.util.List;

public class UserService implements IUserService {

    private IUserDao userDao = new UserDao();

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean update(int id, User user) {
        return userDao.update(id, user);
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findUserByName(String user_name) {
        return userDao.findUserByName(user_name);
    }

    @Override
    public boolean login(String user_name, String password) {
        User user = userDao.findByUserNameAndPassword(user_name, password);
        if (user != null) {
            return true;
        }
        return false;
    }

}
