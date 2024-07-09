package servlets;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BuscadorService;

@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	@Inject
	private BuscadorService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.eliminarResultado(Integer.parseInt(request.getParameter("idResultado")));
		
	}

}
