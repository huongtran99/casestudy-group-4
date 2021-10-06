<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product list</h1>
<a href="/product?action=create">Create new product</a>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Code</td>
        <td>Description</td>
        <td>Price</td>
        <td>Image</td>
        <td>Inventory</td>
        <td>Category_id</td>
        <td>Brand_id</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <th scope="row">${product.product_id}</th>
            <td>${product.product_name}</td>
            <td>${product.product_code}</td>
            <td>${product.description}</td>
            <td>${product.product_price}</td>
            <td><img src="${product.product_image}" alt="ava" height="100" width="100"></td>
            <td>${product.product_inventory}</td>
            <td>${product.category_id}</td>
            <td>${product.brand_id}</td>
            <td><a href="/product?action=edit&product_id=${product.product_id}">Edit</a></td>
            <td><a href="/product?action=delete&product_id=${product.product_id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>