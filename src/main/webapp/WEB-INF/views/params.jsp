<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 5/27/2019
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Params Page</title>
</head>
<body>

    <h3>${name} is ${age} years old</h3>

    <spring:form>
        <label for="name"></label>
        <spring:input path="name" id="name"/>
        <label for="email"></label>
        <spring:input path="email" id="email"/>
    </spring:form>
</body>
</html>
