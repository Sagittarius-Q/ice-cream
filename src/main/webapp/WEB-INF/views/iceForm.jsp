<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>
<body>

<form class="name-form" method="post" action="/ice/add" enctype="multipart/form-data">
    Name:<input class="name-form" type="text" name="name" placeholder="Title of description" /><br>
    Descrption:<input class="description-form" type="text" name="description" placeholder="Description"/><br>
   Photos: <input type="file" name="photo">
    <input class="submit-form" type="submit" />
</form>
</body>
</html>