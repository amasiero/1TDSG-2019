package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.lista1.dao.ProdutoDAO;
import br.com.fiap.lista1.model.entities.Produto;

@WebServlet(urlPatterns = "/pesquisar")
public class ProdutosSerlvet extends HttpServlet{

	private static final long serialVersionUID = 6538749295362096588L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("<h2>Produtos Cadastrados</h2>");
		out.println("<table border=\"1\">");
		out.println("<tr><td>Nome do Produto</td><td>Quantidade</td></tr>");
		ArrayList<Produto> produtos = new ProdutoDAO().consultarTodos();
		
		for(int i = 0; i < produtos.size(); i++) {
			Produto p = produtos.get(i);
			out.println("<tr><td>" + p.getNome() + "</td><td>"
					+ p.getQuantidadeEmEstoque() + "</td></tr>");
		}
		
		out.println("</table>");
		out.println("<a href=\"index.html\">Voltar para home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}
}
