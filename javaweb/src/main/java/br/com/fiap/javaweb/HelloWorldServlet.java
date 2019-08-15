package br.com.fiap.javaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = -7294921192524273228L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String palavra = req.getParameter("palavra");
		String nome = req.getParameter("nome");

		PrintWriter out = resp.getWriter();

		out.println("<html><body>");
		out.println("<h1>Hello Servlet!!!</h1>");
		out.println("<h2>" + nome +"</h2>");
		out.println("<h2>A palavra digitada foi: " + palavra + "</h2>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
