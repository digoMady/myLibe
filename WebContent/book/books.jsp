<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />
<div id="mylibe" align="center">
    <br/><br/>
    <h3>Minha Biblioteca</h3>
    <!--filtro-->
    <br/>
    <form method="post" action="${raiz}/bookcrud">
        <input type="hidden" name="acao" value="filter" />
        <fieldset>
            <h4 class="interno">Filtro</h4>            
            <div class="search">
            <label>Nome</label>
            <input type="text" name="filter" value="${param.nomeFiltro}" size="50" maxlength="50"/>
           <ul class="bs-glyphicons-list"> <li>
          <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
               </li></ul>
            <input type="submit" value="Search" class="bt-search">
            </div>
        </fieldset>
    </form>
    <font color="#FF0000">${erro}</font>
    <font color="#00FF00">${mensagem}</font>
    <p />
    <table border="1" width="780">
        <thead>
            <tr>
                <th>N</th>
                <th>Nome do Livro</th>
                <th>Escritor</th>
                <th>Tipo</th>
                <th width="60">&nbsp;</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="linha" value="0" />
            <c:forEach var="book" items="${books}">
                <c:set var="linha" value="${linha+1}" />
                ${linha%2==0?'<tr class="odd">':'<tr class="even">'}
            <td align="center">${linha}</td>
            <td align="left">${book.name}</td>
            <td align="left">${book.writer}</td>
            <td align="left">${book.type}</td>
            <td align="center">
                <a href="${raiz}/bookcrud?acao=update&id=${book.id}">
                    <img src="${raiz}/pix/edit.svg" border="0" width="25%" title="Alterar Livro" alt="Alterar Livro"></a>&nbsp;
                <a href="${raiz}/bookcrud?acao=delete&id=${book.id}">
                    <img src="${raiz}/pix/delete.svg" border="0" width="20%" title="Excluir Livro" alt="Excluir Livro"></a>
                <a href="${raiz}/bookcrud?acao=view&id=${book.id}">
                    <img src="${raiz}/pix/view.svg" border="0" width="30%" tile="Ver Livro" alt="Ver Livro"></a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p />
    <a href="${raiz}/bookcrud?acao=insert">Incluir Livro</a>
</div>
