package br.com.fiap.estacionamento.model.bo;

import java.util.List;

import br.com.fiap.estacionamento.model.dao.ValetDAO;
import br.com.fiap.estacionamento.model.entities.Valet;
import br.com.fiap.estacionamento.model.entities.Veiculo;

public class ValetBO {

	public List<Valet> getEstacionados() {
		List<Valet> valets = new ValetDAO().getEstacionados();
		if (!valets.isEmpty()) {
			return valets;
		} else {
			return null;
		}
	}
	
	public void salvarValet(Veiculo veiculo) {
		if(veiculo != null) {
			new ValetDAO().registrarEntrada(veiculo);
		}
	}

}
