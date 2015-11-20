<%-- 
    Document   : alert
    Created on : 15/11/2015, 00:21:12
    Author     : mady
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${alert == 'success'}">
    <div class="alert alert-success" role="alert">${msg}</div>
</c:if>
<c:if test="${alert == 'info'}">
    <div class="alert alert-info" role="alert">${msg}</div>
</c:if>
<c:if test="${alert == 'warning'}">
    <div class="alert alert-warning" role="alert">${msg}</div>
</c:if>
<c:if test="${alert == 'erro'}">
    <div class="alert alert-danger" role="alert">${msg}</div>
</c:if>