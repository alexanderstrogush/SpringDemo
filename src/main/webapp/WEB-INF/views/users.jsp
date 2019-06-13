<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 6/10/2019
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <caption>Users</caption>
    <tr>
        <th>Id</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Password</th>
        <th>Roles</th>
    </tr>

    <c:forEach items="${users}" var="u">
        <tr>
            <td><c:out value="${u.id}"/></td>
            <td><c:out value="${u.firstName}"/></td>
            <td><c:out value="${u.lastName}"/></td>
            <td><c:out value="${u.email}"/></td>
            <td><c:out value="${u.password}"/></td>
            <td>
                <c:forEach items="${u.roles}" var="r">
                    <c:out value="${r.name}"/> <br>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
