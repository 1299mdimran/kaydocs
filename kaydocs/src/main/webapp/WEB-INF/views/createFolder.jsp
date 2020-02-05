<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Folder</title>
</head>
<body>
<div align="center">
<form  method="POST"
				action="/createFolder" object="${createFolder}"> 
<table>
<tr><td>Folder Name</td><td><input type="text" name="folderName" placeholder="Create Folder"></td></tr></table><br>
<input type="submit" value= "submit">

</form>
</div>



</body>
</html>