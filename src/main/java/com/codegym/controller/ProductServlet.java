package com.codegym.controller;

import com.codegym.dao.user.UserDao;
import com.codegym.model.*;
import com.codegym.service.brand.BrandService;
import com.codegym.service.brand.IBrandService;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.order.IOrderService;
import com.codegym.service.order.OrderService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();
    private IBrandService brandService = new BrandService();
    private UserDao userDao = new UserDao();
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showProductCreateFrom(request, response);
                break;
            }
            case "edit": {
                showProductEditFrom(request, response);
                break;
            }
            case "delete": {
                showProductDeleteFrom(request, response);
                break;
            }
            case "view": {
                showDetailProduct(request, response);
                break;
            }
            default: {
                showProductList(request, response);
                break;
            }
        }
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.findById(id);
        User user = userDao.user;
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/product/product_detail.jsp");
            request.setAttribute("product", product);
            request.setAttribute("user", user);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/product/delete.jsp");
            request.setAttribute("product", product);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductEditFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("products", product);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        try {
            List<Category> categories = categoryService.getAll();
            request.setAttribute("categories", categories);
            List<Brand> brandList = brandService.getAll();
            request.setAttribute("brands", brandList);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user_name = request.getParameter("q");
        List<Product> products;
        if (user_name == null || user_name.equals("")) {
            products = productService.getAll();
        } else {
            products = productService.findProductByName(user_name);
            response.sendRedirect("/categories");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        request.setAttribute("products", products);
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
                addProduct(request, response);
                break;
            }
            case "edit": {
                editProduct(request, response);
                break;
            }
            case "delete": {
                deleteProduct(request, response);
            }
            case "buy": {
                addUserOrder(request, response);
            }
        }
    }

    private void addUserOrder(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        boolean isDelete = productService.delete(product_id);
        String message = "";
        if (isDelete) {
            message = "Create success!";
        } else {
            message = "Create fail!";
        }
        request.setAttribute("message", message);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        String product_name = request.getParameter("name");
        String product_code = request.getParameter("code");
        String description = request.getParameter("description");
        double product_price = Double.parseDouble(request.getParameter("price"));
        String product_image = request.getParameter("image");
        int product_inventory = Integer.parseInt(request.getParameter("inventory"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int brand_id = Integer.parseInt(request.getParameter("brand_id"));
        Product product = new Product(product_id, product_name, product_code, description, product_price, product_image, product_inventory, category_id, brand_id);
        productService.update(product_id, product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String product_name = request.getParameter("name");
        String product_code = request.getParameter("code");
        String description = request.getParameter("description");
        double product_price = Double.parseDouble(request.getParameter("price"));
        String product_image = request.getParameter("image");
        int product_inventory = Integer.parseInt(request.getParameter("inventory"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int brand_id = Integer.parseInt(request.getParameter("brand_id"));
        Product product = new Product(product_name, product_code, description, product_price, product_image, product_inventory, category_id, brand_id);
        boolean isCreated = productService.save(product);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "Create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
