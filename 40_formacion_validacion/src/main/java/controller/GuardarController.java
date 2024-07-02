package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

@WebServlet("/GuardarController")
public class GuardarController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=new CursosService();
		boolean res=service.nuevo(new Curso(0,request.getParameter("nombre"),
				request.getParameter("tematica"),
				Integer.parseInt(request.getParameter("duracion")),
				Double.parseDouble(request.getParameter("precio"))));
		if(!res) {
			request.setAttribute("mensaje", "Ya existe un curso con ese nombre!");
		}
		
	}

}
