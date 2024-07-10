package controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import dtos.ClienteDto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ClientesService;

@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	@Inject
	ClientesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDto dto=new ClienteDto(request.getParameter("usuario"),
				request.getParameter("password"), 
				request.getParameter("email"), 
				Integer.parseInt(request.getParameter("telefono")));		
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.print(service.registrar(dto));
	}
}
