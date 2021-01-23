<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>
<body>

<%--@elvariable id="iceForm" type="com.location.iceCream.model.binding.BindingIceCreamDto"--%>
<form:form class="name-form" method="post" action="/ice/add" enctype="multipart/form-data" modelAttribute="iceForm">
    Name:<form:input class="name-form" type="text" name="name" placeholder="Title of description"  path="name"/><br>
    Description:<form:input class="description-form" type="text" name="description" placeholder="Description" path="description"/><br>
   Photos: <form:input type="file" name="photo" path="image"/>
    <input class="submit-form" type="submit" />
</form:form>
</body>
</html>