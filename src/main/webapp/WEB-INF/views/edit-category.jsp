<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 6/4/2019
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
</head>
<body>

    <h2>Edit category</h2>

    <spring:form modelAttribute="category" action="/edit-category" method="post">
        <spring:input path="id" hidden="true"/>
        <label for="name">Name</label>
        <spring:input path="name" id="name"/>
        <label for="description">Description</label>
        <spring:input path="description" id="description"/>
        <button type="submit">Submit</button>
    </spring:form>

</body>
</html>
