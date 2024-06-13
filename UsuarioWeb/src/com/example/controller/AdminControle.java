package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;

/**
 * Servlet implementation class AdminControle
 */
@WebServlet("/auth/admin")
public class AdminControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;

	public AdminControle() {
		super();
	}

	public void init() {
		usuarioDAO = new UsuarioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "listar":
				listarUsuario(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	private void listarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		List<Usuario> usuarios = usuarioDAO.listarTodosUsuarios();

		request.setAttribute("listaUsuarios", usuarios);

		String path = request.getServletPath() + "/listar-usuarios.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		dispatcher.forward(request, response);
	}

}
