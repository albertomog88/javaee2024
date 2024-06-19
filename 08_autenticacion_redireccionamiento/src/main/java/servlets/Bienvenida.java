package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Bienvenida")
public class Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//generamos la página de respuesta
		try(PrintWriter out=response.getWriter()){
			out.println("<html><head></head><body><center>");
			out.println("<h2>Bienvenido "+request.getParameter("username")+" a mi página</h2>");
			out.println("</center></body></html>");
		}
	}

}
