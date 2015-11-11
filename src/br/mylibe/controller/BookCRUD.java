package br.mylibe.controller;

import br.mylibe.model.DAO.BookDAO;
import br.mylibe.model.negocio.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookCRUD
 */
@WebServlet("/bookcrud")
public class BookCRUD extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);

        String acao = request.getParameter("acao"); //get what to do
        String page = null; //page that will be request
        BookBean book = new BookBean();
        BookDAO bookDao;
        List<BookBean> books = null;

        if (session.getAttribute("logged") != null) {
            page = "/login.jsp";
        } else {
            try {
                bookDao = new BookDAO();

                //listar
                if ((acao == null) || (acao.equals("list"))) {
                    books = bookDao.list();
                    request.setAttribute("books", books);
                    page = "/book/mybooks.jsp?content=books";

//                    response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println(request.getParameter(page));
//                    
                } //filtrar
                else if (acao.equals("filter")) {
                    books = bookDao.list(request.getParameter("filter"));
                    request.setAttribute("books", books);
                    page = "/book/mybooks.jsp?content=books";
                } //incluir
                else if (acao.equals("insert")) {
                    request.setAttribute("book", book);
                    page = "/book/mybooks.jsp?content=addbook";
                } //alterar
                else if (acao.equals("update")) {
                    book = bookDao.read(Integer.valueOf(request.getParameter("id")));
                    request.setAttribute("book", book);
                    page = "/book/mybooks.jsp?content=addbook";
                } //salvar
                else if (acao.equals("save")) {
                    // Get the values from the form
                    try {
                        if (request.getParameter("name") != null) {
                            book.setName(request.getParameter("name"));
                        }
                        if (request.getParameter("writer") != null) {
                            book.setWriter(request.getParameter("writer"));
                        }
                        if (request.getParameter("description") != null) {
                            book.setDescription(request.getParameter("description"));
                        }
                        if (request.getParameter("pages") != null) {
                            book.setPages(Integer.parseInt(request.getParameter("pages")));
                        }
                        // Salva: inclui ou altera
                        if (request.getParameter("id").equals("0")) { // Incluir
                            if (bookDao.create(book) > 0) {
                                request.setAttribute("mensagem", "Incluído com sucesso");
                            } else {
                                request.setAttribute("erro", "Erro de inclusão");
                            }
                        } else { // Alterar
                            book.setId(Integer.valueOf(request.getParameter("id")));
                            if (bookDao.update(book) > 0) {
                                request.setAttribute("mensagem", "Alterado com sucesso");
                            } else {
                                request.setAttribute("erro", "Erro de alteração");
                            }
                        }
                        books = bookDao.list();
                        request.setAttribute("books", books);
                        page = "/book/mybooks.jsp?content=books";
                    } catch (NumberFormatException e) {
                        request.setAttribute("erro", "Erro de conversao de numero " + e + request.getParameter("id").equals("0"));
                        page = "/book/mybooks.jsp?content=addbook";
                    }

                } //excluir
                else if (acao.equals("delete")) {
                    book = bookDao.read(Integer.valueOf(request.getParameter("id")));
                    if (bookDao.delete(book) > 0) {
                        request.setAttribute("mensagem", "Excluído com sucesso");
                    } else {
                        request.setAttribute("erro", "Erro de exclusão");
                    }
                    books = bookDao.list();
                    request.setAttribute("books", books);
                    page = "/book/mybooks.jsp?content=books";
                }
            } catch (SQLException e) {
                request.setAttribute("erro", "Erro de banco de dados - " + e.getMessage());
                page = "/book/mybooks.jsp?content=books";
            }
        }

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println(request.getParameter(page));
        dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }
}
