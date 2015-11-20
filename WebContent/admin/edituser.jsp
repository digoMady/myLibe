<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="add-user">    
    <div class="form add-user-form bs-example" style="max-width: 40%">
        <h3 align="center">${(user.id==0) || (param.id==0) ? 'Inclusao':'Alteracao'}</h3>
        <form action="${raiz}/usercrud" method="post" id="add-user-form">
            <div class="form-group">
                <input type="hidden" value="save" name="acao"/>
                <input type="hidden" name="id" value="${user.id == null ? 0 : user.id}" />
                <label>Nome*</label>
                <input type="text" class="form-control" name="name" 
                       value="${user.name == null ? param.name : user.name}" placeholder="Nome" required />
                <label>Sobrenome</label>
                <input type="text" class="form-control" name="lastName" 
                       value="${user.lastName == null ? param.lastName : user.lastName}" placeholder="Sobrenome" />
                <label>E-mail*</label>
                <input type="email" class="form-control" name="email"
                       value="${user.email == null ? param.email : user.email}" placeholder="E-mail" required />
                <c:if test="${logged.type == 'ADMIN'}">
                    <label>Tipo de Usuario</label><br/>
                    <select name="type">
                        <c:forEach var="type" items="${types.valores}">
                            <option ${(user.type==type)||(param.type==type)?'selected':''}>${type}</option>
                        </c:forEach>
                    </select><br/>
                </c:if>
                <label>Nome do usuário*</label>
                <c:if test="${user.id != 0}">
                    <input type="text" class="form-control" name="username" readonly="readonly"
                           value="${user.username == null ? param.username : user.username}" placeholder="Usuário" required />
                </c:if>
                <c:if test="${user.id == 0}">
                    <input type="text" class="form-control" name="username"
                           value="${user.username == null ? param.username : user.username}" placeholder="Usuário" required />
                </c:if>
                <label>Senha*</label>
                <input type="password" class="form-control" name="password"
                       value="${user.password == null ? param.password : user.password}" placeholder="Senha" required/><br/>
                <div class='required-data'>
                    <p>*campos obrigatórios</p>
                </div>

                <div buttons-form align="center">
                    <c:if test="${user.id == 0}">
                        <input type="button" class="btn btn-warning" onclick="resetForm('add-user-form')" value="Limpar os Dados"/>
                    </c:if>                    
                    <input type="button" class="btn btn-default" value="Cancelar" 
                           onclick="window.location = '${raiz}/usercrud';"/>
                    <input type="submit" class="btn btn-success" value="${(user.id==0) || (param.id==0) ? 'Incluir':'Alterar'} Usuário"/>
                </div>
            </div>
        </form>
    </div>    
</div>


