package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8904725475248951225L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		if(usuario.equals("admin") && senha.equals("123")) {
			out.println("<h2> Usuário " + usuario 
					+ " logado com sucesso.</h2>");
			
			Cookie cookie = new Cookie("usuario.logado", usuario);
			resp.addCookie(cookie);
			
		} else {
			out.println("<h2>Usuário ou senha inválidos.</h2>");
		}
		out.println("<a href=\"index.html\">Ir para home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
