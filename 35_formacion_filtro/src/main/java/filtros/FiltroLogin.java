package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroLogin extends HttpFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//recuperamos el atributo de sesión: usuario
		String usuario=(String)((HttpServletRequest)request).getSession().getAttribute("usuario");
		String param=request.getParameter("operation");
		//si el atributo de sesión existe, el usuario se autenticó
		//y le dejamos pasar
		if(usuario!=null||(param!=null&&param.equals("doLogin"))) {
			chain.doFilter(request, response);
		}else {
			request.getRequestDispatcher("login.html").forward(request, response);	
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
