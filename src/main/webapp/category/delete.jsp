<%--
  Created by IntelliJ IDEA.
  User: TauruSs
  Date: 05-Oct-21
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Category Create Form</h1>
<a href="/categories">Category Delete Form</a>
<form method="post">
    <div>
        <h3>Category name: </h3>
        <p>${categories.category_name}</p>
    </div>
    <button>Delete</button>
</form>
</body>
</html>
