<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Home</title><
    /head>
<body>
<c:forEach items="${list}" var="item">
    <tr>
        <td><c:out value="${item.name}"/></td>
        <td><c:out value="${item.owner.username}"/></td>
        <td><c:out value="${item.description}"/></td>
    </tr>
</c:forEach>
</body>
</html>