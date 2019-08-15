package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.lista1.bussiness.ProdutoBO;
import br.com.fiap.lista1.dao.ProdutoDAO;
import br.com.fiap.lista1.model.entities.Produto;

@WebServlet(urlPatterns = "/produto")
public class ProdutoServlet extends HttpServlet{

	private static final long serialVersionUID = -3091759827994826888L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String nome = req.getParameter("nome");
		
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		
		Produto p = new Produto(nome, quantidade);
		
		out.println("<html><body>");
		out.println("<h2>Cadastramento de Produtos</h2>");
		if(new ProdutoBO().validarProduto(p)) {
			new ProdutoDAO().adicionarProduto(p);
			out.println("<p> O produto " + p.getNome() 
				+ " foi cadastrado com sucesso!</p>");
			out.println("<p> Está com " + p.getQuantidadeEmEstoque() +
					" unidades em estoque.</p>");
		}else {
			out.println("<p>É necessário informar o nome e "
					+ "a quantidade em estoque.</p>");
		}
		out.println("<a href=\"index.html\">Voltar para home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}
	
}





