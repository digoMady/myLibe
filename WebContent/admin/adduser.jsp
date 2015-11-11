
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="add-user">
    <h3>Adicionar Usu�rio</h3>
    <div class="form add-user-form">
        <form action="${raiz}/usercrud" method="post">
            
            <legend>
                    <b>${(user.id==0) || (param.id==0) ? 'Incluis&atilde;o':'Altera&ccedil;&atilde;o'}	do Usu�rio</b>
            </legend>
            <input type="hidden" name="id" value="${user.id == null ? param.id : user.id}" />
            <input type="hidden" value="add-user" name="acao"/>
            <label>Nome</label>
            <input type="text" name="name" placeholder="Nome" required /><br/>
            <label>Sobrenome</label>
            <input type="text" name="lastName" placeholder="Sobrenome" /><br/>
            <label>E-mail</label>
            <input type="email" name="email" placeholder="E-mail" required /><br/>
            <label>Nome do usu�rio</label>
            <input type="text" name="username" placeholder="Usu�rio" required /><br/>
            <label>Senha</label>
            <input type="password" name="password" placeholder="Senha" required/><br/>            
            <input type="reset" value="Limpar os Dados"/>
            <input type="submit" value="Adicionar Usu�rio"/>
            <input type="button" value="Cancelar" onclick="cancelAdd()"/>
        </form>
    </div>    
</div>

