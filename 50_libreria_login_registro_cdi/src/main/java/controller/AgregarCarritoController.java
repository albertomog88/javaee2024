package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import dtos.LibroDto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.LibrosService;

@WebServlet("/AgregarCarritoController")
public class AgregarCarritoController extends HttpServlet {
	@Inject
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		HttpSession sesion=request.getSession();
		
		//recogemos el libro cuyo ISBN se recibe como parámetro
		LibroDto libro=service.getLibro(isbn);
		List<LibroDto> carrito=new ArrayList<>();
		if(sesion.getAttribute("carrito")!=null) {
				carrito=(List<LibroDto>)sesion.getAttribute("carrito");
		}
		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);
		//envía como respuesta un JSON con los datos del carrito
		Gson gson=new Gson();
		try(PrintWriter out=response.getWriter();){
			response.setContentType("application/json");
			out.println(gson.toJson(carrito));
		}
	}

}
