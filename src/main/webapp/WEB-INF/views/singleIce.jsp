<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
</head>
<body>
<table>
    <tr>
        <td><h1>${ice.name}</h1></td>
        <td>${ice.owner.username}</td>
        <td>${ice.description}</td>
        <img src="data:image/jpeg;base64,${img}" alt="No image" width="500" height="600">
    </tr>
</table>
</body>
</html>