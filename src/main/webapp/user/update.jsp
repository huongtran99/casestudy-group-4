<%--
  Created by IntelliJ IDEA.
  User: dangv
  Date: 10/5/2021
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="user?action=user">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <tr>
                <th>User Id:</th>
                <td>
                    <input type="text" name="user_id" size="45" value="${users.user_id}"/>
                </td>
            </tr>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="user_name" size="45" value="${users.user_name}"/>
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <input type="text" name="password" size="15" value="${users.password}"/>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${users.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Role:</th>
                <td>
                    <input type="text" name="role" size="15"
                           value="<c:out value='${users.role}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" size="15"
                           value="<c:out value='${users.gender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" size="15"
                           value="<c:out value='${users.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Avatar:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${users.avatar}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>About:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${users.about}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
