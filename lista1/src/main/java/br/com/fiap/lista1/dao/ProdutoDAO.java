package br.com.fiap.lista1.dao;

import java.util.ArrayList;

import br.com.fiap.lista1.model.entities.Produto;

public class ProdutoDAO {
	private static ArrayList<Produto> produtos = new ArrayList<>();
	
	public void adicionarProduto(Produto p) {
		produtos.add(p);
	}
	
	public ArrayList<Produto> consultarTodos() {
		return produtos;
	}
	
	public Produto consultarPorNome(String nome) {
		for(int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
				return produtos.get(i);
			}
		}
		return null;
	}
}
