package com.codegym.controller;

import com.codegym.dao.user.UserDao;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryServlet extends HttpServlet {
    private ICategoryService categoryService = new CategoryService();
    private IProductService productService = new ProductService();
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showCategoryCreate(request, response);
                break;
            }
            case "delete": {
                showDeleteForm(request, response);
                break;
            }
            case "edit": {
                showEditCategoryForm(request, response);
                break;
            }
            case "view": {
                showProductByCategory(request, response);
                break;
            }
            default: {
                showCategoryList(request, response);
                break;
            }

        }
    }

    private void showProductByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        List<Product> products = productService.findProductByCategoryId(categoryId);
        User user = userDao.user;
        request.setAttribute("products",products);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/category/list_product.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditCategoryForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("category_id"));
        Category category = categoryService.findById(id);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("category_id"));
        Category oldCategory = categoryService.findById(id);
        RequestDispatcher requestDispatcher;
        if (oldCategory == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/category/delete.jsp");
            request.setAttribute("categories", oldCategory);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCategoryCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/category/create.jsp");
        List<Category> categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCategoryList(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories = categoryService.getAll();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/category/list.jsp");
        request.setAttribute("categories", categories);
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
                addCategory(request, response);
                break;
            }
            case "delete": {
                deleteCategory(request, response);
                break;
            }
            case "edit": {
                editCategory(request, response);
                break;
            }
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("category_id"));
        String name = request.getParameter("category_name");
        Category category = categoryService.findById(id);
        RequestDispatcher dispatcher;
        if (category == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            category.setCategory_name(name);
            categoryService.update(id, category);
            request.setAttribute("category", category);
            request.setAttribute("message", "Category information was updated");
            dispatcher = request.getRequestDispatcher("category/edit.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("category_id"));
        categoryService.delete(id);
        try {
            response.sendRedirect("/categories");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("category_name");
        Category category = new Category(name);
        boolean isCreated = categoryService.save(category);
        String message = "";
        if (isCreated) {
            message = "Create success";
        } else {
            message = "Create fail";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/category/create.jsp");
        request.setAttribute("message", message);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
