package br.com.fiap.estacionamento.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.estacionamento.model.bo.ValetBO;
import br.com.fiap.estacionamento.model.entities.Veiculo;

@WebServlet(urlPatterns = "/registrar_valet")
public class ValetServlet extends HttpServlet {

	private static final long serialVersionUID = -4897072213971233247L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		String placa = req.getParameter("placa");
		
		Veiculo v = new Veiculo(marca, modelo, placa);
		
		ValetBO bo = new ValetBO();
		bo.salvarValet(v);
		
		req.setAttribute("valets", bo.getEstacionados());
		
		req.getRequestDispatcher("valet.jsp").forward(req, resp);
	}

}
