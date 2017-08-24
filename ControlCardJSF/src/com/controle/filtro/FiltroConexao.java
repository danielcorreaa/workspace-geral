package com.controle.filtro;

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

public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		
		if(user!=null){
			chain.doFilter(req, resp);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public boolean ehPermitido(String uri) {
		String separar[] = uri.split("/|\\.");
		for (int i = 0; i < separar.length; i++) {
			System.out.println(separar[i]);
		}
		if (paginasPermitidas().contains(separar[separar.length - 3])) {			
			return true;
		}
		return false;
	}

	public List<String> paginasPermitidas() {
		List<String> permitidos = new ArrayList<String>();
		permitidos.add("estilo");
		permitidos.add("materialize.min");
		permitidos.add("materialize");
		permitidos.add("Roboto-Bold");
		permitidos.add("Roboto-Light");
		permitidos.add("Roboto-Medium");
		permitidos.add("Roboto-Regular");
		permitidos.add("Roboto-Thin");
		permitidos.add("login");
		permitidos.add("cartaocorrente");
		
		return permitidos;
	}

}
