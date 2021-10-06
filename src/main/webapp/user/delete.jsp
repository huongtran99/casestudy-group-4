<%--
  Created by IntelliJ IDEA.
  User: dangv
  Date: 10/5/2021
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user">Show User list</a>
<h1>Delete user form</h1>
<form method="post">
    <div>
        <p>${users.user_name}</p>
    </div>
    <button>Delete</button>
</form>
</body>
</html>
