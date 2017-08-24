package com.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String key = request.getParameter("key");
		//System.out.println(key);
		if(key!=null){
			int keychar = key.charAt(0);
			//System.out.println(keychar);
			String decimalString = Integer.toString(keychar);
			//System.out.println(decimalString);
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(decimalString);
		}else{
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("?");
		}
		
	}
	

}
