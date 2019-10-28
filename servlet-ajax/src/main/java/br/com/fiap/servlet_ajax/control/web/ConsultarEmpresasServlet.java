package br.com.fiap.servlet_ajax.control.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fiap.servlet_ajax.model.dao.EmpresaDAO;
import br.com.fiap.servlet_ajax.model.entities.Empresa;

@WebServlet("/empresas")
public class ConsultarEmpresasServlet extends HttpServlet {

	private static final long serialVersionUID = 4975393732667867710L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String filtro = req.getParameter("filtro");
		
		List<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(empresas));
	}

}
