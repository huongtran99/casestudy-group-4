<%--
  Created by IntelliJ IDEA.
  User: TauruSs
  Date: 05-Oct-21
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<h1>Category Edit form</h1>
<a href="/categories">Show Category List</a>
<c:if test="${message != null}">
    <p>${message}</p>
</c:if>
<form method="post">
    <div>
        <h3>Category name: </h3>
        <p>${category.category_name}</p>
    </div>
    <div>
        <input type="text" placeholder="Category new name" name="category_name">
    </div>
    <button>Edit</button>
</form>
</body>
</html>
