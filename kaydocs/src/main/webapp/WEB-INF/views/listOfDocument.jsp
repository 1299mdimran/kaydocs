 <!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.project.kaydocs.entities.Document" %>
<% ArrayList<String> document=(ArrayList)request.getAttribute("document"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Document</title>
</head>
<body>
<table>
<tr><c:forEach items="${document}" var="asr">
<c:out value="${asr.document}"/>
</c:forEach> 
<tr><td>"${document}"</td>
</table>
KayDoc List
</body>
</html>