
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="add-book">
    <div class="form add-book-form">
        <h3 align="center">${(book.id==0) || (param.id==0) ? 'Inclusão':'Alteração'} do Livro</h3>
        <form action="${raiz}/bookcrud" id="add-book-form" method="post">
            <div class="form-group">
                <input type="hidden" name="id" value="${book.id == null ? param.id : book.id}" />
                <input type="hidden" value="save" name="acao"/>
                <label>Nome</label>
                <input type="text" class="form-control" name="name" placeholder="Nome do Livro" required min="3"
                       value="${book.name==null ? param.name : book.name}" /><br/>
                <label>Escritor</label>
                <input type="text" class="form-control" name="writer" placeholder="Nome do Escritor" min="3"
                       value="${book.writer==null ? param.writer : book.writer}"/><br/>
                <label>Número de Páginas</label>
                <input name="pages" class="form-control" type="number" placeholder="Páginas" required min="1"
                       value="${book.pages==null ? param.pages : book.pages}"><br/>
                <label>Tipo de Livro</label><br/>
                <select name="type">
                    <c:forEach var="type" items="${types.valores}">
                        <option ${(book.type==type)||(param.type==type)?'selected':''}>${type}</option>
                    </c:forEach>
                </select><br/>
                <label>Descrição</label>
                <textarea rows="4" class="form-control" cols="50" rows="5" cols="50" name="description" placeholder="Descrição do livro" 
                          required min="20"/>${book.description==null ? param.description : book.description}</textarea><br/>
                <div class="buttons-form" align="center">
                    <c:if test="${book.id == 0}"> 
                        <input type="button" class="btn btn-warning" onclick="resetForm('add-book-form')" value="Limpar os Dados"/>
                    </c:if>
                    <input type="button" class="btn btn-default" value="Cancelar" onclick="window.location = '${raiz}/bookcrud';"/>
                    <input type="submit" class="btn btn-success" value="${(book.id==0) || (param.id==0) ? 'Incluir':'Alterar'} Livro"/>                
                </div>
            </div>
        </form>
        <%@ include file= "/alert/alert.jsp" %>
    </div>    
</div>