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

@WebServlet(urlPatterns = "/inserir")
public class InserirServlet extends HttpServlet {

	private static final long serialVersionUID = -726978449140553528L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("veiculo", new Veiculo("ABC-1234", "i8", "BMW"));
		
		ServletContext context = getServletContext();
		context.setAttribute("data", new Date());
		
		resp.getWriter().println("<h1>Veiculo inserido com sucesso!</h1>");
	}
	
}




