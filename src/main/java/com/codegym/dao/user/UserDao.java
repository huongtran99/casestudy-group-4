package com.codegym.dao.user;

import com.codegym.dao.DBConnection;
import com.codegym.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                user = getUser(user_id, user, resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean save(User user) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into users(user_name, password, email, gender, phone, about) value (?,?,?,?,?,?)");
            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getGender());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getAbout());
            isCreated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, User user) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement("update users set user_name = ?, password = ?, email = ?, role = ?, gender = ?, phone = ?, avatar = ?, about = ? where user_id = ?");
            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getRole());
            statement.setString(5, user.getGender());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getAvatar());
            statement.setString(8, user.getAbout());
            statement.setInt(9, user.getUser_id());
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from users where user_id = ?");
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users where user_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = getUser(id, user, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {
        List<User> user = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users where user_name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String avatar = resultSet.getString("avatar");
                String about = resultSet.getString("about");
                user.add(new User(user_id, name, password, email, role, gender, phone, avatar, about));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public User findByUserNameAndPassword(String user_name, String password) {
        User user = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select * from users where user_name = ? and password = ?;");
            statement.setString(1, user_name);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String avatar = rs.getString("avatar");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String about = rs.getString("about");
                user = new User(user_id, user_name, password, email, role, gender, phone, avatar, about);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User getUser(int id, User user, ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("user_name");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        String role = resultSet.getString("role");
        String gender = resultSet.getString("gender");
        String phone = resultSet.getString("phone");
        String avatar = resultSet.getString("avatar");
        String about = resultSet.getString("about");
        user = new User(id, name, password, email, role, gender, phone, avatar, about);
        return user;
    }
}
