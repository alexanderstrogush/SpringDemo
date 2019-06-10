<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 6/8/2019
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<table>
    <caption>Products</caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>

    <c:forEach var="p" items="${products}">
        <tr>
            <td><c:out value="${p.id}"/></td>
            <td><c:out value="${p.name}"/></td>
            <td><c:out value="${p.description}"/></td>
            <td><c:out value="${p.price}"/></td>
<%--            <td><a href="/edit-category?c_id=${c.id}">Edit</a></td>--%>
<%--            <td><a href="/delete-category?c_id=${c.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
</table>

</body>
</html>
