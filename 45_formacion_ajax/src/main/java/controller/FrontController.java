package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("operation");
		String urlView="";
		switch(op) {
			case "doBuscar"->{
				request.getRequestDispatcher("BuscarController").forward(request, response);
				return;
			}
			case "doEliminar"->{
				request.getRequestDispatcher("EliminarController").include(request, response);
				urlView="eliminar.jsp";
			}
			case "doGuardar"->{
				request.getRequestDispatcher("GuardarController").include(request, response);
				urlView="nuevo.jsp";
			}
			case "doLogin"->{
				request.getRequestDispatcher("LoginController").include(request, response);
				
				urlView=(Boolean)request.getAttribute("autenticado")?"menu.html":"error.jsp";
				
			}
			case "doModificar"->{
				request.getRequestDispatcher("ModificarController").include(request, response);
				urlView="modificar.jsp";
			}
			case "toNuevo"->urlView="nuevo.jsp";
				
			case "toEliminar"->urlView="eliminar.jsp";
			
			case "toBuscar"->urlView="buscar.html";
			case "toMenu"->urlView="menu.html";

			case "toModificar"->urlView="modificar.jsp";
			default->urlView="login.html";
		};
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
