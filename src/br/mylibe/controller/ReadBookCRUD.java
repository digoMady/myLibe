/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mylibe.controller;

import br.mylibe.model.DAO.BookDAO;
import br.mylibe.model.DAO.ReadBookDAO;
import br.mylibe.model.enums.BookClass;
import br.mylibe.model.negocio.BookBean;
import br.mylibe.model.negocio.ReadBookBean;
import br.mylibe.model.negocio.UserBean;
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
 *
 * @author mady
 */
@WebServlet(name = "ReadBookCRUD", urlPatterns = {"/readbookcrud"})
public class ReadBookCRUD extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);

        String acao = request.getParameter("acao"); //get what to do
        String page = null; //page that will be request
        ReadBookBean read = new ReadBookBean();
        ReadBookDAO readDao;
        List<ReadBookBean> rbooks = null;

        if (session.getAttribute("logged") == null) {
            page = "/login.jsp";
        } else {
            read.setUser((UserBean) session.getAttribute("logged"));
            
            String userHash = read.getUser().getHash(); //use for filter by user            
            try {
                readDao = new ReadBookDAO();

                //listar
                if ((acao == null) || (acao.equals("list"))) {
                    rbooks = readDao.list(userHash);
                    request.setAttribute("books", books);
                    page = "/book/mybooks.jsp?content=books";

                } //filtrar
                else if (acao.equals("filter")) {
                    books = bookDao.list(filter, userHash);
                    request.setAttribute("books", books);
                    if (filter.trim().isEmpty()) {
                        request.setAttribute("status", false);
                    } else {
                        request.setAttribute("status", true);
                    }
                    page = "/book/mybooks.jsp?content=books";

                } //view
                else if (acao.equals("view")) {
                    book = bookDao.read(Integer.valueOf(request.getParameter("id")), userHash);
                    if (book == null) {
                        request.setAttribute("alert", "erro");
                        request.setAttribute("msg", "Error in find for view!");
                    } else {
                        request.setAttribute("book", book);
                        request.setAttribute("types", BookClass.DRAMA);
                        page = "/book/mybooks.jsp?content=viewbook";
                    }

                } //incluir
                else if (acao.equals("insert")) {
                    request.setAttribute("book", book);
                    request.setAttribute("types", BookClass.DRAMA);
                    page = "/book/mybooks.jsp?content=addbook";

                } //alterar
                else if (acao.equals("update")) {
                    book = bookDao.read(Integer.valueOf(request.getParameter("id")), userHash);
                    if (book == null) {
                        request.setAttribute("alert", "erro");
                        request.setAttribute("msg", "Error in find for update!");
                    } else {
                        request.setAttribute("book", book);
                        request.setAttribute("types", BookClass.DRAMA);
                        page = "/book/mybooks.jsp?content=addbook";
                    }

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
                        if (request.getParameter("type") != null) {
                            book.setType(BookClass.valueOf(request.getParameter("type")));
                        }

                        // Salva: inclui ou altera
                        if (request.getParameter("id").equals("0")) { // Incluir
                            if (bookDao.create(book) > 0) {
                                request.setAttribute("alert", "success");
                                request.setAttribute("msg", "Insert with success!");
                            } else {
                                request.setAttribute("alert", "erro");
                                request.setAttribute("msg", "Error in insert!");
                            }
                        } else { // Alterar
                            book.setId(Integer.valueOf(request.getParameter("id")));
                            if (bookDao.update(book) > 0) {
                                request.setAttribute("alert", "success");
                                request.setAttribute("msg", "Update with success!");
                            } else {
                                request.setAttribute("alert", "erro");
                                request.setAttribute("msg", "Error in update!");
                            }
                        }
                        books = bookDao.list(userHash);
                        request.setAttribute("books", books);
                        page = "/book/mybooks.jsp?content=books";

                    } catch (NumberFormatException e) {
                        request.setAttribute("alert", "erro");
                        request.setAttribute("msg", "Error converting number: " + e);
                        page = "/book/mybooks.jsp?content=addbook";
                    }

                } //excluir
                else if (acao.equals("delete")) {
                    book = bookDao.read(Integer.valueOf(request.getParameter("id")), userHash);
                    if (bookDao.delete(book) > 0) {
                        request.setAttribute("alert", "success");
                        request.setAttribute("msg", "Deteled with success!");
                    } else {
                        request.setAttribute("alert", "erro");
                        request.setAttribute("msg", "Error in delete!");
                    }
                    books = bookDao.list(userHash);
                    request.setAttribute("books", books);
                    page = "/book/mybooks.jsp?content=books";
                }
            } catch (SQLException e) {
                request.setAttribute("alert", "erro");
                request.setAttribute("msg", "Error in Database: " + e.getMessage());
                page = "/book/mybooks.jsp?content=books";
            }
        }

        dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}
