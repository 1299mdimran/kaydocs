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
<form   action="/uploadDocument" method="POST" enctype="multipart/form-data"> 
<table>
<tr>
<td>Folder Id</td>
<td><input type="text" name="folderId"  placeholder="Folder Id"></td>
</tr><br>
<tr>
<td>Folder Id</td>
<td><input type="text" name="filename"  placeholder="file name"></td>
</tr><br>

<tr>
<td>Upload Document</td><td><input type="File" name="filedata"  placeholder="Upload File"></td>
</tr><br>

<tr><input type="submit" value= "submit"></tr>
</table>

</form>
</div>



</body>
</html>