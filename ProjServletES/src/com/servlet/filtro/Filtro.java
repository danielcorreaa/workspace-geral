package com.servlet.filtro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





public class Filtro implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");

		if (user != null || ehPermitido(request.getRequestURI())) {
			chain.doFilter(arg0, arg1);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	public boolean ehPermitido(String uri) {
		String separar[] = uri.split("/|\\.");
		if (paginasPermitidas().contains(separar[separar.length - 2])) {
			return true;
		}
		return false;
	}

	public List<String> paginasPermitidas() {
		List<String> permitidos = new ArrayList<>();
		permitidos.add("login");
		permitidos.add("loginEstilo");
		permitidos.add("GeosansLight");
		permitidos.add("enviarEmail");
		
		return permitidos;
	}

}
