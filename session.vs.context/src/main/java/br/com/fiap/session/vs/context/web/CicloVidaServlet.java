package br.com.fiap.session.vs.context.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ciclo")
public class CicloVidaServlet extends HttpServlet{

	private static final long serialVersionUID = -8603099557799318187L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet criada no servidor!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Método get executado!");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet destruida no servidor!");
	}

}
