<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Category list</h1>
<a href="/categories?action=create">Create new category</a>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <th scope="row">${category.category_id}</th>
            <td>
                <a href="/categories?action=view&category_id=${category.category_id}">
                        ${category.category_name}
                </a>
            </td>
            <td><a href="/categories?action=delete&category_id=${category.category_id}">Delete</a></td>
            <td><a href="/categories?action=edit&category_id=${category.category_id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
