package br.com.fiap.lista2.bussiness;

import br.com.fiap.lista2.dao.UsuarioDAO;
import br.com.fiap.lista2.model.entities.Usuario;

public class UsuarioBO {

	public Usuario validarLogin(Usuario u) {
		Usuario usuario = new UsuarioDAO().consultarLogin(u.getLogin());
		if(usuario == null) return null;
		if(!u.getSenha().equals(usuario.getSenha())) return null;
		return usuario;
	}
}
