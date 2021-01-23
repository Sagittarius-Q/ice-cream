<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%--@elvariable id="list" type="java.util.List"--%>
<c:forEach items="${list}" var="item">
    <tr>
        <td><c:out value="${item.name}"/></td>
        <td><c:out value="${item.ownerUsername}"/></td>
        <td><c:out value="${item.description}"/></td>
        <td> <img src="data:image/jpeg;base64,${item.image}" alt="No image" width="500" height="600"></td>
    </tr>
</c:forEach>
</body>
</html>