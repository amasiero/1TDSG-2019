package br.com.fiap.estacionamento.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.estacionamento.model.entities.Usuario;
import br.com.fiap.estacionamento.model.services.ConnectionFactory;

public class UsuarioDAO {
	
	public Usuario consultarPorEmailESenha(String email, String senha) {
		Usuario usuario = null;
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("select * from usuario where email = ? and senha = ?");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				email = rs.getString("email");
				senha = rs.getString("senha");
				usuario = new Usuario(nome, email, senha);
				usuario.setId(id);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

}
