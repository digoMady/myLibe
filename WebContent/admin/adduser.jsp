
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="add-user">    
    <div class="form add-user-form bs-example" style="max-width: 40%">
        <h3 align="center">Adicionar Usuário</h3>
        <form action="${raiz}/usercrud" method="post" id="add-user-form">
            <div class="form-group">
                <input type="hidden" value="save" name="acao"/>
                <input type="hidden" name="id" value="0" />
                <label>Nome*</label>
                <input type="text" class="form-control" name="name" placeholder="Nome" required />
                <label>Sobrenome</label>
                <input type="text" class="form-control" name="lastName" placeholder="Sobrenome" />
                <label>E-mail*</label>
                <input type="email" class="form-control" name="email" placeholder="E-mail" required />
                <label>Nome do usuário*</label>
                <input type="text" class="form-control" name="username" placeholder="Usuário" required />
                <label>Senha*</label>
                <input type="password" class="form-control" name="password" placeholder="Senha" required/><br/>
                <div class='required-data'>
                    <p>*campos obrigatórios</p>
                </div>
                <div buttons-form align="center">
                    <input type="button" class="btn btn-warning" onclick="resetForm('add-user-form')" value="Limpar os Dados"/>
                    <input type="button" class="btn btn-default" value="Cancelar" onclick="cancelAdd()"/>
                    <input type="submit" class="btn btn-success" value="Adicionar Usuário"/>
                </div>
            </div>
        </form>
    </div>    
</div>

