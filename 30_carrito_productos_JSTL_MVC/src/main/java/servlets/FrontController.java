package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlVista="";
		String operation=request.getParameter("operation");
		urlVista=switch(operation) {
			case "doAgregar"->{
				request.getRequestDispatcher("AgregarCarritoAction").include(request, response);
				yield "menu.html";
			}
			case "doEliminar"->{
				request.getRequestDispatcher("EliminarCarritoAction").include(request, response);
				yield "carrito.jsp";
			}
			case "doCerrar"->{
				request.getRequestDispatcher("CerrarSesionAction").include(request, response);
				yield "menu.html";
			}
			case "toAlta"->"alta.html";
			case "toCarrito"->"carrito.jsp";
			default ->"menu.html";
		};
		//transferimos el control a la vista definitiva
		request.getRequestDispatcher(urlVista).forward(request, response);
	}

}
