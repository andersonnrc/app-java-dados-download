package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;

@WebServlet("/auth/admin/exportar-usuarios-csv")
public class ExportarUsuariosCsvServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Usuario> listaUsuarios = usuarioDAO.listarTodosUsuarios();
            exportarUsuariosParaCsv(response, listaUsuarios);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void exportarUsuariosParaCsv(HttpServletResponse response, List<Usuario> listaUsuarios) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=usuarios.csv");

        PrintWriter writer = response.getWriter();
        writer.println("ID,NAME,E-MAIL,DATA,COMPANY,CITY,REGION,COUNTRY");

        for (Usuario usuario : listaUsuarios) {
            writer.println(usuario.getId() + "," + 
                           usuario.getName() + "," + 
                           usuario.getEmail() + "," + 
                           usuario.getDataCadastro() + "," + 
                           usuario.getCompany() + "," + 
                           usuario.getCity() + "," + 
                           usuario.getRegion() + "," + 
                           usuario.getCountry());
        }
        writer.flush();
        writer.close();
    }
}