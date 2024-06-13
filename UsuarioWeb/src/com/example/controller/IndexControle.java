package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.util.ManipulacaoData;
import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;



/**
 * Servlet implementation class IndexControle
 */
@WebServlet("/publica")
public class IndexControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO usuarioDAO;

	public IndexControle() {
		super();
	}	

	public void init() {
		usuarioDAO = new UsuarioDAO();
	}
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "novo":
				novoUsuario(request, response);
				break;
			case "inserir":
				gravarUsuario(request, response);
				break;
			}
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	
	private void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void gravarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dataCadastro = request.getParameter("dataCadastro");
		String company = request.getParameter("company");
		String city = request.getParameter("city");		
		String region = request.getParameter("region");
		String country = request.getParameter("country");
		String postalZip = request.getParameter("postalZip");
		
		ManipulacaoData manipulacaoData = new ManipulacaoData();
		Date dataNascimento = manipulacaoData.converterStringData(dataCadastro);
		
		Usuario usuario = new Usuario(name, email, dataCadastro, company, city, region, country, postalZip);
		
		Usuario usuarioGravado = usuarioDAO.inserirUsuario(usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		request.setAttribute("mensagem", "Usuário cadastrado com sucesso");
		dispatcher.forward(request, response);
	}

}
