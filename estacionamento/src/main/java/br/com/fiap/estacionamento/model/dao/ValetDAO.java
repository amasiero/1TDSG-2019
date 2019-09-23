package br.com.fiap.estacionamento.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.estacionamento.model.entities.Valet;
import br.com.fiap.estacionamento.model.entities.Veiculo;
import br.com.fiap.estacionamento.model.services.ConnectionFactory;

public class ValetDAO {

	public void registrarEntrada(Veiculo veiculo) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"insert into valet(id, marca, modelo, placa, entrada)" + " values(?, ?, ?, ?, ?)");
			stmt.setLong(1, this.gerarId());
			stmt.setString(2, veiculo.getMarca());
			stmt.setString(3, veiculo.getModelo());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setDate(5, new java.sql.Date(new Date().getTime()));

			stmt.execute();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Valet> getEstacionados() {
		List<Valet> valets = new ArrayList<Valet>();

		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"select * from valet where saida is null");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Long id = rs.getLong("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String placa = rs.getString("placa");
				Date entrada = rs.getDate("entrada");
			
				Valet v = new Valet(
						new Veiculo(marca, modelo, placa), 
						entrada);
				v.setId(id);
				
				valets.add(v);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return valets;
	}

	private Long gerarId() {
		Long id = 0l;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("select * from valet");

			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				id++;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return id + 1;
	}

}
