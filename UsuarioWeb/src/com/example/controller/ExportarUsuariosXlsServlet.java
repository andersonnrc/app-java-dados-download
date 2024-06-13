package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;

@WebServlet("/auth/admin/exportar-usuarios-xls")
public class ExportarUsuariosXlsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Usuario> listaUsuarios = usuarioDAO.listarTodosUsuarios();
            exportarUsuariosParaXls(response, listaUsuarios);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void exportarUsuariosParaXls(HttpServletResponse response, List<Usuario> listaUsuarios) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=usuarios.xls");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Usuários");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("NAME");
        header.createCell(2).setCellValue("E-E-MAIL");
        header.createCell(3).setCellValue("DATA");
        header.createCell(4).setCellValue("COMPANY");
        header.createCell(5).setCellValue("CITY");
        header.createCell(6).setCellValue("REGION");
        header.createCell(7).setCellValue("COUNTRY");

        int rowIdx = 1;
        for (Usuario usuario : listaUsuarios) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(usuario.getId());
            row.createCell(1).setCellValue(usuario.getName());
            row.createCell(2).setCellValue(usuario.getEmail());
            row.createCell(3).setCellValue(usuario.getDataCadastro());
            row.createCell(4).setCellValue(usuario.getCompany());
            row.createCell(5).setCellValue(usuario.getCity());
            row.createCell(6).setCellValue(usuario.getRegion());
            row.createCell(7).setCellValue(usuario.getCountry());
            row.createCell(8).setCellValue(usuario.getPostalZip());
        }

        workbook.write(response.getOutputStream());
        workbook.cloneSheet(0);
    }
}

