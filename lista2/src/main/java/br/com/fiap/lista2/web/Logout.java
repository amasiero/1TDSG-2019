package br.com.fiap.lista2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logout", urlPatterns = { "/logout" })
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
   	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("usuario.logado")) {
				cookie = cookies[i];
			}
		}
		
		if(cookie != null) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		
		resp.sendRedirect("index.html");
		
	}

}
