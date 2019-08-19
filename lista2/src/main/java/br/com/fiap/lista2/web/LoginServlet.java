package br.com.fiap.lista2.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.lista2.bussiness.UsuarioBO;
import br.com.fiap.lista2.model.entities.Usuario;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 6461321197743743524L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario u = new Usuario(login, senha);
		u = new UsuarioBO().validarLogin(u);
		
		out.println("<html><body>");
		
		if(u == null) {
			out.println("<h2>Usuário e/ou senha inválidos!</h2>");
		}else {
			out.println("<h2> O usuario " + u.getNome() + " está logado com sucesso.</h2>");
		}
		out.println("<a href=\"index.html\">Voltar para Home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
	
	}
}
