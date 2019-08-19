package br.com.fiap.lista1.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 7422564249100817393L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
		
		resp.sendRedirect("index.html");
	}

}
