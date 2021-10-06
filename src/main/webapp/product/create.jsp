<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product">Show products list</a>
<h1>Product Create Form</h1>
<c:if test="${message}">
    <p>${message}</p>
</c:if>
<form method="post">
    <div>
        <input type="text" placeholder="product name" name="name">
    </div>

    <div>
    <input type="text" placeholder="product code" name="code">
    </div>

    <div>
    <input type="text" placeholder="product description" name="description">
    </div>

    <div>
        <input type="text" placeholder="product price" name="price">
    </div>

    <div>
        <input type="text" placeholder="product image" name="image">
    </div>

    <div>
        <input type="text" placeholder="product inventory" name="inventory">
    </div>

    <div>
        <input type="text" placeholder="category id" name="category_id">
    </div>

    <div>
        <input type="text" placeholder="brand id" name="brand_id">
    </div>
    <button type="submit">Create</button>
</form>
</body>
</html>