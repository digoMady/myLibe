<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="raiz" value="${pageContext.request.contextPath}" />

<div id="mylibe" align="center">
    <h2>Minha Biblioteca</h2>
    <!--filtro-->
    <br/>
    <form method="post" id="search-book-form" action="${raiz}/bookcrud">
        <input type="hidden" name="acao" value="filter" />      
        <div class="search">
            <label>Nome</label>
            <input type="text" name="filter" value="${param.filter}" size="50" maxlength="50"/>
            <a href="#" id="bt-search" title="Search" onclick="document.getElementById('search-book-form').submit();">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
            </a>        
            <c:if test="${status}">
                <a href="${raiz}/bookcrud?acao=filter&filter=" id="bt-search" title="Reset Filter">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </a>
            </c:if>
        </div>
    </form>
    <div class="msg-error">
        <%@ include file= "/alert/alert.jsp" %>
    </div>
    <p />
    <div style="max-width: 80%">
        <table border="1" class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome do Livro</th>
                    <th>Escritor</th>
                    <th>Tipo</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="linha" value="0" />
                <c:forEach var="book" items="${books}">
                    <c:set var="line" value="${line+1}" />
                    ${line%2==0?'<tr class="odd">':'<tr class="even">'}
                <td align="center">${line}</td>
                <td align="left">${book.name}</td>
                <td align="left">${book.writer}</td>
                <td align="left">${book.type}</td>
                <td align="center">
                    <a href="${raiz}/bookcrud?acao=update&id=${book.id}">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true" alt="Alterar Livro" title="Alterar Livro"></span></a>&nbsp;

                    <a class="delete-book" href="${raiz}/bookcrud?acao=delete&id=${book.id}">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true" alt="Excluir Livro" title="Excluir Livro"></span></a>

                    <a href="${raiz}/readbookcrud?acao=add&id=${book.id}">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true" alt="Comecar a ler livro" title="Comecar a ler livro"></span></a>

                    <a href="${raiz}/bookcrud?acao=view&id=${book.id}" target="_blank">
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true" alt="Ver Livro" title="Ver Livro"></span></a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br/>
    <button type="button" onclick="window.location = '${raiz}/bookcrud?acao=insert';" 
            class="btn btn-success">Adicionar Livro</button>
    <br/>
</div>
<script>
    $("a.delete-book").click(function (e) {
        e.preventDefault();
        var r = confirm("Want to delete?");
        var url = $(this).attr("href");
        if (r) {
            window.location = url;
        }
    });
</script>