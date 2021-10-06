<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product">Show products list</a>
<h1>Product edit Form</h1>
<c:if test="${message}">
    <p>${message}</p>
</c:if>
<form method="post">
    <div>
        <input type="text" name="product_id" value="${products.product_id}"  >
    </div>

    <div>
        <input type="text" name="name" value="${products.product_name}">
    </div>

    <div>
        <input type="text" name="code" value="${products.product_code}">
    </div>

    <div>
        <input type="text" name="description" value="${products.description}">
    </div>

    <div>
    <input type="text" name="price" value="${products.product_price}">
    </div>

    <div>
        <input type="text" name="image" value="${products.product_image}">
    </div>

    <div>
        <input type="text" name="inventory" value="${products.product_inventory}">
    </div>

    <div>
        <input type="text" name="category_id" value="${products.category_id}">
    </div>

    <div>
        <input type="text" name="brand_id" value="${products.brand_id}">
    </div>
    <button type="submit">EDIT</button>
</form>
</body>
</html>