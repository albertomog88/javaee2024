package servlets;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContadorLikes")
public class ContadorLikes extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contador=1;
		String nombre=request.getParameter("opcion");
		ServletContext context=request.getServletContext();
		if(context.getAttribute(nombre)!=null) {
			contador=(int)context.getAttribute(nombre);
			contador++;
		}
		context.setAttribute(nombre, contador);
		request.getRequestDispatcher("like.jsp").forward(request, response);
	}

}
