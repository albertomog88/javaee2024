package controller;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ClientesService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	@Inject
	ClientesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean res=service.autenticar(request.getParameter("usuario"), request.getParameter("password"));
		if(res) {
			request.getSession().setAttribute("usuario", request.getParameter("usuario"));
		}
		request.setAttribute("autenticado", res);
	}

}
