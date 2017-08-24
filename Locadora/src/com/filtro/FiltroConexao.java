package com.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltroConexao implements Filter{

	@Override
	public void init(FilterConfig conf) throws ServletException {
		
	}

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(req, resp);
		
	}
	@Override
	public void destroy() {
		
	}


}
