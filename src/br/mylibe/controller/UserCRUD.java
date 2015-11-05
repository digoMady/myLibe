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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		//var for filter which action to do
		String acao=request.getParameter("acao"), pagina=null;
		
		UserBean user = new UserBean();
		UserDAO userDao;	
		List<UserBean> users = null;  
		
		try {
			userDao = new UserDAO();
			
			if ((acao != null) && (acao.equals("create"))) {
				user = userDao.read(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("user", user);
				pagina = "/index.jsp?content=adminConfig";		
			}
			
			if ((acao == null) || (acao.equals("readLogin"))) {
				//validate user and password
				userDao.read(request.getParameter("username"), request.getParameter("password"));
				request.setAttribute("users", users);
				pagina = "/index.jsp";				
			}
			
			if ((acao != null) && (acao.equals("update"))) {
				request.setAttribute("user", user);
				pagina = "/index.jsp?content=adminConfig";
				user = userDao.consultar(request.getParameter("id"));
				request.setAttribute("curso", curso);
				pagina = "/entidades/cursoEntrada.jsp";		
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
			
			
			
			
			
			if ((acao != null) && (acao.equals("salvar"))) {
				try {
					// Recebe valores do formulario
					if (request.getParameter("nome") != null)
						curso.setNome(request.getParameter("nome"));
					if (request.getParameter("semestres") != null)
						curso.setSemestres(Integer.parseInt(request.getParameter("semestres")));
					if (request.getParameter("valor") != null)
						curso.setValor(Float.parseFloat(request.getParameter("valor").replace(',', '.')));
					// Salva: inclui ou altera
					if (request.getParameter("id").equals("0")) { // Incluir
						if (cursoDao.incluir(curso) > 0)
							request.setAttribute("mensagem", "Inclu�do com sucesso");
						else
							request.setAttribute("erro", "Erro de inclus�o");
					}
					else { // Alterar
						curso.setId(Long.valueOf(request.getParameter("id")));
						if (cursoDao.alterar(curso) > 0)
							request.setAttribute("mensagem", "Alterado com sucesso");
						else
							request.setAttribute("erro", "Erro de altera��o");
					}
					cursos = cursoDao.listar();
					request.setAttribute("cursos", cursos);
					pagina = "/entidades/cursoLista.jsp";
				}
				catch (NumberFormatException e) {
					request.setAttribute("erro", "Erro de conversao de numero");
					pagina = "/entidades/cursoEntrada.jsp";		
				}
			}
			
			if ((acao != null) && (acao.equals("excluir"))) {
				curso = cursoDao.consultar(Long.valueOf(request.getParameter("id")));
				try {
					if (cursoDao.excluir(curso) > 0)
						request.setAttribute("mensagem", "Exclu�do com sucesso");
					else
						request.setAttribute("erro", "Erro de exclus�o");
				} catch (MySQLIntegrityConstraintViolationException e) {
					request.setAttribute("erro", "Esse curso n�o pode ser excluido porque possui alunos.");
				}
				finally {
					cursos = cursoDao.listar();
					request.setAttribute("cursos", cursos);
					pagina = "/entidades/cursoLista.jsp";
				}
			}
		} catch (SQLException e) {
			request.setAttribute("erro", "Erro de banco de dados");
			pagina = "/entidades/cursoLista.jsp";
		}
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
