package br.mylibe.controller;


import br.mylibe.model.DAO.UserDAO;
import br.mylibe.model.negocio.UserBean;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
        String acao = request.getParameter("acao"), page = null;
        UserBean user = new UserBean();

        try {
            if (acao == null) {
                user = (new UserDAO()).read(request.getParameter("username"));
                if ((user != null) && (user.isRightPwd(request.getParameter("password")))) {
                    session.setAttribute("logged", user);
                    session.setAttribute("userId", user.getId());
                    request.setAttribute("mensagem", "Usuário logado");
                    page = "/index.jsp";
                } else {
                    request.setAttribute("erro", "Usuario e/ou senha incorretos");
                    page = "/login.jsp";
                }
            } else 
            if (acao.equals("logoff")) {
                session.removeAttribute("logged");
                request.setAttribute("mensagem", "Loging off!");
                page = "/index.jsp";
            }
        } catch (SQLException e) {
            request.setAttribute("erro", "Erro de banco de dados (" + e.getMessage() + ")");
            page = "/login.jsp";
        }
        dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
