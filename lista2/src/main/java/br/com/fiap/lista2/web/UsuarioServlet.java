package br.com.fiap.lista2.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.lista2.dao.UsuarioDAO;
import br.com.fiap.lista2.model.entities.Usuario;

@WebServlet(urlPatterns = "/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 5014907064446783720L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("usuario.logado")) {
				cookie = cookies[i];
			}
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		
		if (cookie == null) {
			String nome = req.getParameter("nome");
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");

			Usuario u = new Usuario(nome, login, senha);
			new UsuarioDAO().adicionar(u);

			out.println("<h2> O usuario " + u.getNome() + " foi cadastrado com sucesso.</h2>");
		}else {
			out.println("<h2> O usuario " + cookie.getValue() + " já possui cadastro.</h2>");
		}
		
		out.println("<a href=\"index.html\">Voltar para Home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();

	}
}
