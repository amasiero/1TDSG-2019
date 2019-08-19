package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.lista1.model.entities.Produto;

@WebServlet(urlPatterns="/exercicio5")
public class Exercicio5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		Produto[] produtos = new Produto[5];
		produtos[0] = new Produto("caneta", 20);
		produtos[1] = new Produto("lapis", 10);
		produtos[2] = new Produto("caderno", 30);
		produtos[3] = new Produto("borracha", 40);
		produtos[4] = new Produto("giz de cera", 60);
		
		PrintWriter out = resp.getWriter();
 		out.println("<html><body>");
 		out.println("<table border=\"1\">");
 		
 		out.println("<tr><th>Descrição</th><th>Quantidade em Estoque</th></tr>");
 		
 		for(int i = 0; i < produtos.length; i++) {
 			out.println("<tr><td>" + produtos[i].getNome()
 					+ "</td><td>" + produtos[i].getQuantidadeEmEstoque()
 					+ "</td></tr>");
 		}
 		
 		out.println("</table>");
 		out.println("</body></html>");
 		out.flush();
 		out.close();
	}
}








