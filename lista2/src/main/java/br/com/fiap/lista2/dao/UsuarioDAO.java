package br.com.fiap.lista2.dao;

import java.util.ArrayList;

import br.com.fiap.lista2.model.entities.Usuario;

public class UsuarioDAO {
	
	private static ArrayList<Usuario> USUARIOS = new ArrayList<>();
	
	public void adicionar(Usuario u) {
		USUARIOS.add(u);
	}
	
	public ArrayList<Usuario> consultarTodos() {
		return USUARIOS;
	}
	
	public Usuario consultarLogin(String login) {		
		for(Usuario u : USUARIOS) {
			if(u.getLogin().equals(login)) {
				return u;
			}
		}
		return null;
	}

}







