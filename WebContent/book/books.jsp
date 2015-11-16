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
    <%@ include file= "/alert/alert.jsp" %>
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

                    <a href="#myModal" data-toggle="modal" data-target="#book-delete-modal" data-whatever="@mdo">
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
<div class="modal fade" id="book-delete-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Delete</h4>
            </div>
            <div class="modal-body">
                <p>Are sure that you want to delete the book?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onclick="window.location = 'bookcrud?acao=delete&id=${book.id}';">Delete book</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
    $('#book-delete-modal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('Delete book ' + ${book.id != null ? book.id : "1"});
        modal.find('.modal-body input').val(recipient);
    })
</script>