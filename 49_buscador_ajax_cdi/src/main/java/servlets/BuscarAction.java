package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.BuscadorService;

@WebServlet("/BuscarAction")
public class BuscarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuscadorService service=new BuscadorService();
		Resultado resultado=service.buscarResultadoPorId(Integer.parseInt(request.getParameter("idResultado"))).orElse(null);
		request.setAttribute("resultado", resultado);
		
	}

}
