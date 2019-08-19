package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/exercicio6")
public class Exercicio6 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String[] livros = new String[5];
		livros[0] = "O Homem que Calculava";
		livros[1] = "Harry Potter";
		livros[2] = "Game of Thrones";
		livros[3] = "Senhor dos Aneis";
		livros[4] = "O Guia do Mochileiro das Galaxias";
		
		PrintWriter out = resp.getWriter();
 		out.println("<html><body>");
 		out.println("<ul>");
 		
 		for(int i = 0; i < livros.length; i++) {
 			out.println("<li>" + livros[i]
 					+ "</li>");
 		}
 		
 		out.println("</ul>");
 		out.println("</body></html>");
 		out.flush();
 		out.close();
	}
}
