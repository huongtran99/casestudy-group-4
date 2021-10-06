package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showCreateForm(request, response);
                break;
            }
            case "update": {
                showUpdateForm(request, response);
                break;
            }
            case "delete": {
                showDeleteForm(request, response);
                break;
            }
            default: {
                showUserList(request, response);
                break;
            }
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/create.jsp");
        try {
            List<User> user = userService.getAll();
            request.setAttribute("users", user);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.findById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("user/delete.jsp");
            request.setAttribute("users", user);
        }
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/update.jsp");
        request.setAttribute("users", user);
        dispatcher.forward(request, response);

    }


    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        String user_name = request.getParameter("q");
        List<User> users;
        if (user_name == null || user_name.equals("")) {
            users = userService.getAll();
        } else {
            users = userService.findUserByName(user_name);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        request.setAttribute("users", users);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                createUser(request, response);
                break;
            }
            case "update": {
                updateUser(request, response);
                break;
            }
            case "delete": {
                deleteUser(request, response);
                break;
            }
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {

    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("user_id"));
        String name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String avatar = request.getParameter("avatar");
        String about = request.getParameter("about");

        User user = new User(id, name, password, email, role, gender, phone, avatar, about);
        userService.update(id, user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/update.jsp");
        dispatcher.forward(request, response);
    }
}
