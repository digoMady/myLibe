package br.mylibe.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.mylibe.model.DAO.UserDAO;
import br.mylibe.model.negocio.UserBean;

/**
 * Servlet implementation class LoginCRUD
 */
@WebServlet("/usercrud")
public class UserCRUD extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        //var for filter which action to do
        String acao = request.getParameter("acao");
        String pagina = null;

        UserBean user = new UserBean();
        UserDAO userDao;
        List<UserBean> users = null;

        try {
            userDao = new UserDAO();

//            if ((acao != null) && (acao.equals("create"))) {
//                user = userDao.read(Integer.valueOf(request.getParameter("id")));
//                request.setAttribute("user", user);
//                pagina = "/view/admin/admin.jsp";		
//            }
            if ((acao != null) && (acao.equals("include"))) {
                users = userDao.list();
                if (users.size() == 0) {
                    request.setAttribute("erro", "Necessário incluir curso antes de incluir aluno");
                    pagina = "/view/admin/admin.jsp";
                } else {
                    request.setAttribute("user", user);
                    pagina = "/view/admin/admin.jsp";
                }
            }

            if ((acao == null) || (acao.equals("readLogin"))) {
                //validate user and password
                userDao.read(request.getParameter("username"), request.getParameter("password"));
                request.setAttribute("users", users);
                pagina = "/view/admin/admin.jsp";
            }

            if ((acao != null) && (acao.equals("update"))) {
                user = userDao.read(Integer.valueOf(request.getParameter("id")));
                if (user == null) {
                    request.setAttribute("erro", "Erro ao localizar para alteração");
                } else {
                    users = userDao.list();
                    request.setAttribute("user", user);
                    request.setAttribute("users", users);
                    pagina = "/view/admin/admin.jsp";
                }
            }

            if ((acao == null) || (acao.equals("list"))) {
                users = userDao.list();
                request.setAttribute("users", users);
                pagina = "/index.jsp?content=adminConfig";
            }

            if ((acao != null) && (acao.equals("filter"))) {
                users = userDao.list(request.getParameter("filter"));
                request.setAttribute("users", users);
                pagina = "/index.jsp?content=adminConfig";
            }

            if ((acao != null) && (acao.equals("add-user"))) {
                boolean erro = false;
                try {
                    // Get the values from form
                    if (request.getParameter("name") != null) {
                        user.setName(request.getParameter("name"));
                    }
                    if (request.getParameter("lastName") != null) {
                        user.setLastName(request.getParameter("lastName"));
                    }
                    if (request.getParameter("email") != null) {
                        user.setEmail(request.getParameter("email"));
                    }
                    if (request.getParameter("username") != null) {
                        user.setUsername(request.getParameter("username"));
                    }
                    if (request.getParameter("password") != null) {
                        user.setPassword(request.getParameter("password"));
                    }

                    // Salva: inclui ou altera
                    if (request.getParameter("id").equals("0")) { // Incluir
                        if (userDao.create(user) > 0) {
                            request.setAttribute("mensagem", "Incluído com sucesso");
                        } else {
                            request.setAttribute("erro", "Erro de inclusão");
                        }
                    } else { // Alterar
                        user.setId(Integer.valueOf(request.getParameter("id")));
                        if (userDao.update(user) > 0) {
                            request.setAttribute("mensagem", "Alterado com sucesso");
                        } else {
                            request.setAttribute("erro", "Erro de alteração");
                        }
                    }
                    users = userDao.list();
                    request.setAttribute("users", users);
                    pagina = "/view/admin.jsp";
                } catch (NumberFormatException e) {
                    request.setAttribute("erro", "Erro de conversao de numero");
                    pagina = "/view/admin/admin.jsp";
                }
            }

            if ((acao != null) && (acao.equals("delete"))) {
                user = userDao.read(Integer.valueOf(request.getParameter("id")));
                try {
                    if (userDao.delete(user) > 0) {
                        request.setAttribute("mensagem", "Excluído com sucesso");
                    } else {
                        request.setAttribute("erro", "Erro de exclusão");
                    }
                } catch (MySQLIntegrityConstraintViolationException e) {
                    request.setAttribute("erro", "O usuário não.");
                } finally {
                    users = userDao.list();
                    request.setAttribute("users", users);
                    pagina = "/view/admin/admin.jsp";
                }
            }
        } catch (SQLException e) {
            request.setAttribute("erro", "Erro de banco de dados");
            pagina = "/view/admin/admin.jsp";
        }
        dispatcher = request.getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }
}
