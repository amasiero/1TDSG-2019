package br.com.fiap.lista1.model.entities;

public class Produto {
	private String nome;
	private int quantidadeEmEstoque;

	public Produto(String nome, int quantidadeEmEstoque) {
		this.nome = nome;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

}
