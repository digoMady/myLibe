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
</head>
<body class="login-layout">
//breadcrumb
<div class="login" align="center">
	<div>
		<h2>myLibe</h2>
	</div>
	<div class="login-form">
	<form action="${raiz}/usercrud" method="post">
		<input type="hidden" name="acao" value="readLogin"/><br/>
		<label>Username</label>
		<input type="text" name="username" placeholder="Nome do usuário" maxlength="10" required/><br/>		
		<label>Password</label>
		<input type="password" name="password" placeholder="Senha" required/><br/>
		<input class="btn btn-lg btn-success" type="submit" name="login" value="Entrar">
	</form>
	</div>
</div>
<%@ include file="../footer.html" %>
</body>
</html>