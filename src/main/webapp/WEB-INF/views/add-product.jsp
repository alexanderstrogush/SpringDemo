<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 6/10/2019
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding new product</title>
</head>
<body>
    <h2>Add new Product</h2>

    <spring:form modelAttribute="product" action="/add-product" method="post">
        <input type="hidden" value="${param.c_id}" name="c_id"/>
        <label for="name">Name</label>
        <spring:input path="name" id="name"/>
        <label for="description">Descriprion</label>
        <spring:input path="description" id="description"/>
        <label for="price">Price</label>
        <spring:input path="price" id="price"/>
        <button type="submit">Submit</button>
    </spring:form>
</body>
</html>
