
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="add-book" align="center">
    <h3>Adicionar Livro</h3>
    <div class="form add-book-form">
        <font color="#FF0000">${erro}</font>
        <font color="#00FF00">${mensagem}</font>
        <form action="${raiz}/bookcrud" method="post">
            <legend>
                <b>${(book.id==0) || (param.id==0) ? 'Inclusão':'Alteração'} do Livro</b>
            </legend>
            <input type="hidden" name="id" value="${book.id == null ? param.id : book.id}" />
            <input type="hidden" value="save" name="acao"/>
            <label>Nome</label>
            <input type="text" name="name" placeholder="Nome do Livro" required min="3"
                   value="${book.name==null ? param.name : book.name}" /><br/>
            <label>Escritor</label>
            <input type="text" name="writer" placeholder="Nome do Escritor" min="3"
                   value="${book.writer==null ? param.writer : book.writer}"/><br/>
            <label>Número de Páginas</label>
            <input name="pages" placeholder="Páginas" required min="1"
                   value="${book.pages==null ? param.pages : book.pages}"><br/>
            <label>Descrição</label>
            <textarea rows="4" cols="50" rows="5" cols="50" name="description" placeholder="Descrição do livro" 
                      required min="20"/>${book.description==null ? param.description : book.description}</textarea><br/>           
            <input type="reset" value="Limpar os Dados"/>
            <input type="submit" value="Adicionar Livro"/>
            <input type="button" value="Cancelar" onclick="window.location='${raiz}/bookcrud';"/>
        </form>
    </div>    
</div>