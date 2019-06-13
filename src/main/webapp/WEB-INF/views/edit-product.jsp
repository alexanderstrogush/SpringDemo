<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 6/10/2019
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing product</title>
</head>
<body>
    <spring:form modelAttribute="product" action="/edit-product" method="post">
        <input type="hidden" name="c_id" value="${product.category.id}">
        <spring:input path="id" hidden="true"/>
        <label for="name">Name</label>
        <spring:input path="name" id="name"/>
        <label for="description">Description</label>
        <spring:input path="description" id="description"/>
        <label for="price">Price</label>
        <spring:input path="price" id="price"/>
        <button type="submit">Submit</button>
    </spring:form>
</body>
</html>
