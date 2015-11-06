<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyLibe</title>
	<c:set var="raiz" value="${pageContext.request.contextPath}" />
	<link href="${raiz}/style/bootstrap.min.css" rel="stylesheet"> 
	<link href="${raiz}/style/myLibe.css" rel="stylesheet"> 
	<script src="${raiz}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${raiz}/js/bootstrap.min.js" type="text/javascript"></script>
 
</head>
<body>
<%@ include file="navbar.html" %>
<%
	//if (request.getParameter("content").equals("readBooks")) {
		
	//} 
%>
<%@ include file="footer.html" %>
</body>
</html>