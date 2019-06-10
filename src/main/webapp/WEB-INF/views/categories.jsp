<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 5/29/2019
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>

    <a href="/add-category">Add Category</a>

    <table>
        <caption>Categories</caption>
        <tr>
            <th>Name</th>
            <th>Description</th>
        </tr>

        <c:forEach var="c" items="${categories}">
            <tr>
                <td><a href="<c:url value="/products?c_id=${c.id}"/>"><c:out value="${c.name}"/></a></td>
                <td><c:out value="${c.description}"/></td>
                <td><a href="/edit-category?c_id=${c.id}">Edit</a></td>
                <td><a href="/delete-category?c_id=${c.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
