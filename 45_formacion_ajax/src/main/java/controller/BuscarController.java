package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

@WebServlet("/BuscarController")
public class BuscarController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=new CursosService();
		List<Curso> cursos=service.preciosCursoMax(Double.parseDouble(request.getParameter("precio")));
		Gson gson=new Gson();
		try(PrintWriter out=response.getWriter();){
			response.setContentType("application/json");
			out.print(gson.toJson(cursos));
		}
		
	}

}
