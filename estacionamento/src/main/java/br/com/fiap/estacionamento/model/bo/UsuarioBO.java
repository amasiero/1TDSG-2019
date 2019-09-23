package br.com.fiap.estacionamento.model.bo;

import br.com.fiap.estacionamento.model.dao.UsuarioDAO;
import br.com.fiap.estacionamento.model.entities.Usuario;

public class UsuarioBO {

	public Usuario autenticarUsuario(String email, String senha) {
		return new UsuarioDAO().consultarPorEmailESenha(email, senha);
	}
}
