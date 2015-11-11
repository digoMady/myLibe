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
        <script src="${raiz}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
        <script src="${raiz}/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${raiz}/js/user.js" type="text/javascript"></script>

    </head>
    <body>
        <%@ include file= "/navbar.html" %>
        <div id="admin-config" align="center">
            //breadcrumb<br><br>
            <h2>Administrador</h2><br/>
            <div class="admin-user">
                <form action="" id="admin-user-form" method="get">
                    <input type="button" onclick="addUser()" value="Adicionar Usuário" class="mylibe-button">
                    <input type="button" onclick="showUsers()" value="Mostrar Usuários" class="mylibe-button">
                </form>
                <div id="ajax-response"></div>
                <div class="users-list" style="display: none">
                    <h4>Usuários do sistema</h4>
                    <table border="1" width="780" id="users">
                        <thead>
                            <tr bgcolor='#BBBBBB'>
                                <th width="80" align="center">Nome</th>
                                <th width="50" align="center"><i>e-mail</i></th>
                                <th width="40" align="center">Ativo</th>
                                <th width="40">Açoẽs</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <c:set var="linha" value="${line+1}" />
                                ${line%2==0?"<tr class='odd'>":"<tr class='even'>"}
                            <td align="center">${line}</td>
                            <td align="left">${user.name}&nbsp;${user.lastname}</td>
                            <td align="left">${user.email}</td>
                            <td align="center">
                                <a href="${raiz}/cursocrud?acao=edit&id=${curso.id}"><img src="${raiz}/img/alterar.png" border="0" width="15" alt="Alterar Curso"></a>&nbsp;
                                <a href="${raiz}/cursocrud?acao=excluir&id=${curso.id}"><img src="${raiz}/img/excluir.png" border="0" width="15" alt="Excluir Curso"></a>
                            </td>
                            </tr>
                        </c:forEach>	
                        </tbody>
                    </table>
                    <input type="button" onclick="hideUsers()" value="Esconder Usuários" class="mylibe-button">
                </div>

            </div>
            <%
                    //if (request.getParameter("content").equals("readBooks")) {

                    //}
            %>
            <%@ include file="/footer.html" %>
    </body>
</html>