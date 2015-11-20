<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyLibe</title>
        <c:set var="raiz" value="${pageContext.request.contextPath}" />
        <link rel="shortcut icon" href="${raiz}/pix/mylibe.ico">
        <link href="${raiz}/style/bootstrap.min.css" rel="stylesheet"> 
        <link href="${raiz}/style/myLibe.css" rel="stylesheet">
    </head>    
    <body class="login-layout">
        <div class="login ">
            <div class="section-title">
                <h1>MyLibe</h1>
            </div>
            <div class="login-form">
                <c:if test="${logged == NULL}">
                    <form action="${raiz}/login" method="post">
                        <label>Username</label><br/>
                        <input class="lb-text" type="text" name="username" placeholder="Nome do usuário" maxlength="10" required/><br><br/>		
                        <label>Password </label><br/>
                        <input class="lb-text" type="password" name="password" placeholder="Senha" required/><br/><br/>
                        <center style="width: 250px;">
                            <input class="btn btn-lg btn-primary" type="submit" name="login" value="Entrar"><br/><br/>
                            <input class="btn btn-new-lg" onclick="window.location = '${raiz}/usercrud?acao=newuser';" type="button" name="login" value="Criar uma Conta">
                            <c:if test="${erro != NULL}">
                                <br><br>
                                <div class="alert alert-danger" role="alert">${erro}</div>
                            </c:if>
                            <c:if test="${mensagem != NULL}">
                                <br>
                                <div class="alert alert-success" role="alert">${mensagem}</div>
                            </c:if>
                        </center>
                    </form>
                </c:if>
                <c:if test="${logged != NULL}">
                    <center>
                        <input class="btn btn-lg btn-red" onclick="window.location = '${raiz}/login?acao=logoff';"
                               type="button" name="logoff" value="Logoff"><br/><br/>
                        <input class="btn btn-new-lg" onclick="window.location = '${raiz}/index.jsp';" 
                               type="button" name="home" value="Voltar">
                    </center>
                </c:if>

            </div>
        </div>
        <%@ include file="footer.html" %>
    </body>
</html>