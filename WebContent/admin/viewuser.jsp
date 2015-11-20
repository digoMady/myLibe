
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="view-user">
    <div class="view-user">          
        <h2>Usuário ${user.name}</h2>
        <div class="book">    
            <h4>Nome</h4>
            <p>${user.name}</p><br/>
            <h4>Sobrenome</h4>
            <p>${user.lastName}</p><br/>
            <h4>Username</h4>
            <p>${user.username}</p><br/>
            <h4>E-mail</h4>
            <p>${user.email}</p><br/>
            <h4>Papel</h4>
            <p>${user.type}</p>
            <div class="view-book-bt">
                <input type="button" class="btn btn-default" value="Voltar" onclick="window.location = '${raiz}/usercrud';"/>
                <input type="button" class="btn btn-primary" value="Alterar Usuario" onclick="window.location = '${raiz}/usercrud?acao=update&id=${user.id}';"/>
            </div>
        </div>
    </div>    
</div>
