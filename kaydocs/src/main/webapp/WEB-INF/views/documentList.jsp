<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="/documentList" method="post"> 
<table>
<tr><td>Folder Id</td><td><input type="text" name="folderId" placeholder="folder Id" ></td>


<td><input type="submit" value= "submit"></td>
</table>

</form>
</div>

</body>
</html>