
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="view-book">
    <div class="view-book">          
        <h2>Livro ${book.name}</h2>
        <div class="book">    
            <h4>Escritor</h4>
            <p>${book.writer}</p><br/>
            <h4>Número de Páginas</h4>
            <p>${book.pages}</p><br/>
            <h4>Tipo de Livro</h4>
            <p>${book.type}</p><br/>
            <h4>Descrição</h4>
            <p>${book.description}</p>
            <div class="view-book-bt">
                <input type="button" class="btn btn-default" value="Voltar" onclick="window.location = '${raiz}/bookcrud';"/>
                <input type="button" class="btn btn-primary" value="Alterar Livro" onclick="window.location = '${raiz}/bookcrud?acao=update&id=${book.id}';"/>
            </div>
        </div>
    </div>    
</div>
