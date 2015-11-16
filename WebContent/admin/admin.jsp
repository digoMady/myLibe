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
        <link href="${raiz}/style/reset.css" rel="stylesheet"> 
        <link href="${raiz}/style/bootstrap.min.css" rel="stylesheet"> 
        <link href="${raiz}/style/myLibe.css" rel="stylesheet"> 
        <script src="${raiz}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
        <script src="${raiz}/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${raiz}/js/mylibe.js" type="text/javascript"></script>

    </head>
    <body>
        <%@ include file= "/navbar.html" %>
        <div id="admin-config" class="main">
            <h2 align="center">Administrador</h2><br/>
            <div class="admin-user">
                <form action="" id="admin-user-form" method="get" align="center">
                    <input type="button" class="btn btn-success" onclick="addUser()" value="Adicionar Usuário" class="mylibe-button">
                    <input type="button" class="btn btn-success" onclick="window.location = '${raiz}/usercrud';" value="Mostrar Usuários" class="mylibe-button">
                </form>
                <div id="ajax-response"></div>
                 <%@ include file= "/alert/alert.jsp" %>
                <c:if test="${users != NULL}">
                    
                    <div border="1" id="table-user">
                        <h4 align="center" >Usuários do sistema</h4>
                        <table border="1" class="table table-bordered" id="users">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nome</th>
                                    <th><i>E-mail</i></th>
                                    <th>Papel</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${users}">
                                    <c:set var="line" value="${line+1}" />
                                    ${line%2==0?"<tr class='odd'>":"<tr class='even'>"}
                                <td align="center">${line}</td>
                                <td align="left">${user.name}&nbsp;${user.lastName}</td>
                                <td align="left">${user.email}</td>
                                <td align="left">${user.type}</td>
                                <td align="center">
                                    <a href="${raiz}/usercrud?acao=update&id=${user.id}">
                                        <span class="glyphicon glyphicon-edit" aria-hidden="true" alt="Alterar Usuario" title="Alterar Usuario"></span></a>&nbsp;

                                    <a href="#myModal" data-toggle="modal">
                                        <span class="glyphicon glyphicon-remove" aria-hidden="true" alt="Excluir Usuario" title="Excluir Usuario"></span></a>
                                        
                                    <a href="${raiz}/usercrud?acao=view&id=${user.id}" target="_blank">
                                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true" alt="Ver Usuario" title="Ver Usuario"></span></a>
                                </td>
                                </tr>
                            </c:forEach>	
                            </tbody>
                        </table>
                        <input type="button" onclick="hideUsers()" value="Esconder Usuários" class="mylibe-button">
                    </div>
                </c:if>
                <c:if test="${users != NULL}"> 
                    <div class="alert alert-success" role="alert">${mensagem}</div>
                </c:if>

            </div>
            <center style="width: 250px;">
                <c:if test="${erro != NULL}">
                    <br><br>
                    <div class="alert alert-danger" role="alert">${erro}</div>
                </c:if>
                <c:if test="${mensagem != NULL}">
                    <br>
                    <div class="alert alert-success" role="alert">${mensagem}</div>
                </c:if>
            </center>
        </div>
        <%@ include file="/footer.html" %>
    </body>
</html>