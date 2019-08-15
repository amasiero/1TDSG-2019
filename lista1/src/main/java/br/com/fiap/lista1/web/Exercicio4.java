package br.com.fiap.lista1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/exercicio4")
public class Exercicio4 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");

			String modelo = req.getParameter("modelo");
			String marca = req.getParameter("marca");
			String dataTexto = req.getParameter("data");
			
			
			Date data = dataTexto == null ? new Date() : df.parse(dataTexto);

			PrintWriter out = resp.getWriter();

			out.println("<html><body>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>" + marca + "</td><td>" 
					+ modelo + "</td><td>" 
					+ df.format(data) + "</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body></html>");
			out.flush();
			out.close();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
