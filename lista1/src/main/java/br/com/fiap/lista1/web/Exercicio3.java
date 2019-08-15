package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/exercicio3")
public class Exercicio3 extends HttpServlet {

	private static final long serialVersionUID = 4765508249721511065L;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html><body>");

		Date agora = new Date();
		out.println("<h1>"+ df.format(agora) +"</h1>"); 
		
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
