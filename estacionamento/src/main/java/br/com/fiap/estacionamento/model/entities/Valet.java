package br.com.fiap.estacionamento.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Valet {
	
	private Long id;
	private Veiculo veiculo;
	private Date entrada;
	private Date saida;
	private Double preco;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public Valet(Veiculo veiculo, Date entrada) {
		super();
		this.veiculo = veiculo;
		this.entrada = entrada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getEntrada() {
		return entrada;
	}
	
	public String getEntradaEmTexto() {
		return sdf.format(entrada);
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public String getSaidaEmTexto() {
		return sdf.format(saida);
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
