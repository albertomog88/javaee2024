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
		urlView=switch(op) {
			case "doBuscar"->{
				request.getRequestDispatcher("BuscarController").include(request, response);
				yield "cursos.jsp";
			}
			case "doEliminar"->{
				request.getRequestDispatcher("EliminarController").include(request, response);
				yield "eliminar.jsp";
			}
			case "doGuardar"->{
				request.getRequestDispatcher("GuardarController").include(request, response);
				yield "nuevo.jsp";
			}
			case "doLogin"->{
				request.getRequestDispatcher("LoginController").include(request, response);
				
				yield (Boolean)request.getAttribute("autenticado")?"menu.html":"error.jsp";
				
			}
			case "doModificar"->{
				request.getRequestDispatcher("ModificarController").include(request, response);
				yield "modificar.jsp";
			}
			case "toNuevo"->"nuevo.jsp";
				
			case "toEliminar"->"eliminar.jsp";
			
			case "toBuscar"->"buscar.html";
			case "toMenu"->"menu.html";

			case "toModificar"->"modificar.jsp";
			default->"login.html";
		};
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
