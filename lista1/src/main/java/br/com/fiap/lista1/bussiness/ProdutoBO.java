package br.com.fiap.lista1.bussiness;

import br.com.fiap.lista1.model.entities.Produto;

public class ProdutoBO {

	public boolean validarProduto(Produto p) {
		// nome não vazio ou nulo
		// quantidade maior ou igual 0
		return !p.getNome().isEmpty() && p.getQuantidadeEmEstoque() >=0;
	}
	
	public boolean temEmEstoque(Produto p) {
		return p.getQuantidadeEmEstoque() > 0;
 	}
}
