package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/exercicio7")
public class Exercicio7 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		out.println("<html><body>");
		
		out.println("<h2 style=\"color : red;\">Foi feito um GET</h2>");
		
		out.println("</body></html>");
 		out.flush();
 		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		System.out.println("OI!");
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		out.println("<html><body>");
		
		if(usuario.equals("andrey") && senha.equals("java")) {
			out.println("<h2>Usuario logado com sucesso</h2>");
		} else {
			out.println("<h2 style=\"color : red;\">Usuario ou senha incorretos!</h2>");
		}
		
		out.println("</body></html>");
 		out.flush();
 		out.close();
	}
}











