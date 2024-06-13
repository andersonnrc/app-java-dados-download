package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.util.Conexao;
import com.example.model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

	public Usuario inserirUsuario(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario (name, email, dataCadastro, company, city, region, country, postalZip)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
		statement.setString(1, usuario.getName());
		statement.setString(2, usuario.getEmail());
		statement.setString(4, usuario.getDataCadastro());
		statement.setString(5, usuario.getCompany());
		statement.setString(6, usuario.getCity());
		statement.setString(4, usuario.getRegion());
		statement.setString(5, usuario.getCountry());
		statement.setString(6, usuario.getPostalZip());

		statement.executeUpdate();

		/*
		 * ResultSet resultSet = statement.getGeneratedKeys(); long id = 0;
		 * if(resultSet.next()) id = resultSet.getInt("id");
		 */
		statement.close();

		desconectar();

		// usuario.setId(id);
		return usuario;
	}

	public List<Usuario> listarTodosUsuarios() throws SQLException {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuario";

		conectar();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			Long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String dataCadastro = resultSet.getString("dataCadastro");
			String company = resultSet.getString("company");
			String city = resultSet.getString("city");
			String region = resultSet.getString("region");
			String country = resultSet.getString("country");
			String postalZip = resultSet.getString("postalZip");

			Usuario usuario = new Usuario(name, email, dataCadastro, company, city, region, country, postalZip);
			usuario.setId(id);
			listaUsuarios.add(usuario);
		}
		resultSet.close();
		statement.close();

		desconectar();

		return listaUsuarios;
	}

}
