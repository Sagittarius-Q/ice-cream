<%--@elvariable id="ice" type="com.location.iceCream.model.viewer.VIceCream"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<table>
    <tr>
        <td><h1>${ice.name}</h1></td>
        <td>${ice.ownerUsername}</td>
        <td>${ice.description}</td>
        <img src="data:image/jpeg;base64,${ice.image}" alt="No image" width="500" height="600">
    </tr>
</table>
<div>
    <%--@elvariable id="listComments" type="com.location.iceCream.model.viewer.VComment"--%>
    <c:forEach items="${listComments}" var="item">
        <tr>
            <td><c:out value="${item.owner}"/></td>
            <td><c:out value="${item.text}"/></td>
            <td><c:out value="${item.date}"/></td>
        </tr>
    </c:forEach>
</div>

<%--@elvariable id="comment" type="com.location.iceCream.model.binding.BindingCommentDto"--%>
<form:form action="/comment" method="post" modelAttribute="comment">
    <div>
        <form:hidden path="iceCreamName" value="${ice.name}"/>
    </div>
    <div>
        <form:input type="text" name="name" placeholder="Your Name" path="owner"/>
        <form:errors path="owner" cssClass="error"/>
    </div>
    <div>
        <form:input type="text" placeholder="Your comment" path="text"/>
        <form:errors path="text" cssClass="error"/>
    </div>
    <div>
    <input type="submit"  value="add"/>
    </div>

</form:form>
</body>
</html>