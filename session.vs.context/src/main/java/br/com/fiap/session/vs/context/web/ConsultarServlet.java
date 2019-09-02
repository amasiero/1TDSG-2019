package br.com.fiap.session.vs.context.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.session.vs.context.model.entities.Veiculo;

@WebServlet(urlPatterns = "/consultar")
public class ConsultarServlet extends HttpServlet{

	private static final long serialVersionUID = 6549039328177522634L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Veiculo veiculo = (Veiculo) session.getAttribute("veiculo");
		
		ServletContext context = getServletContext();
		Date data = (Date) context.getAttribute("data");
		
		if (veiculo != null) {
			resp.getWriter().println("<h1>Placa: " + veiculo.placa + "</h1>");
			resp.getWriter().println("<h1>Modelo: " + veiculo.modelo + "</h1>");
			resp.getWriter().println("<h1>Marca: " + veiculo.marca + "</h1>");
		}
		
		if (data != null) {
			resp.getWriter().println("<h1>Data: " + data + "</h1>");
		}
		
	}

}






