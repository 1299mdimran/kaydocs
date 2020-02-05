<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta  Content-Type:"application/json" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/deleted" object="${createFolder}" method="post">
<table>
<tr>
<td>Folder Id:<input type="text" name ="folderId" ></td>
<td><input type="submit" value="Delete"></td>
</tr>

</form>

</body>
</html>