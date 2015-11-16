<%-- 
    Document   : alert
    Created on : 15/11/2015, 00:21:12
    Author     : mady
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${mensagem == 'success'}">
    <div class="alert alert-success" role="alert">${tmensagem}</div>
</c:if>
<c:if test="${mensagem == 'info'}">
    <div class="alert alert-info" role="alert">${tmensagem}</div>
</c:if>
<c:if test="${mensagem == 'warning'}">
    <div class="alert alert-warning" role="alert">${tmensagem}</div>
</c:if>
<c:if test="${mensagem == 'erro'}">
    <div class="alert alert-danger" role="alert">${tmensagem}</div>
</c:if>