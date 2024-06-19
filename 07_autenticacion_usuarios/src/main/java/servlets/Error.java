package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter()){
			out.println("<html><head></head><body><center>");
			out.println("<h2>El usuario "+request.getParameter("username")+" con contraseña ");
			out.println(request.getParameter("password")+" no es válido</h2>");
			out.println("<a href='login.html'>Volver</a>");
			out.println("</center></body></html>");
		}
	}

}
