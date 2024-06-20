package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Verificacion")
public class Verificacion extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer.parseInt(request.getParameter("numero"));
			request.getRequestDispatcher("tabla.jsp").forward(request, response);
		}catch(NumberFormatException ex) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
