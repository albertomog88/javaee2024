package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.BuscadorService;

@WebServlet("/BuscarResultadosAction")
public class BuscarResultadosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuscadorService service=new BuscadorService();
		List<Resultado> resultados=service.resultadosPorTematica(request.getParameter("tematica"));
		//hay que entregar la lista directamente al cliente en formato JSON
		Gson gson=new Gson();
		try(PrintWriter out=response.getWriter();){
			response.setContentType("application/json");
			out.println(gson.toJson(resultados));//serializar objetos Java a JSON
		}
		
		
	}

}
