package com.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxResponseServletXml extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String key = request.getParameter("key");
		StringBuffer returnXml = null;
		if (key != null) {
			int keychar = key.charAt(0);
			
			returnXml = new StringBuffer("\r\n<converted-values>");
			returnXml.append("\r\n<decimal>" + Integer.toString(keychar) + "</decimal>");
			returnXml.append("\r\n<hexadecimal>" + Integer.toString(keychar, 16) + "</hexadecimal>");
			returnXml.append("\r\n<octal>" + Integer.toString(keychar, 8) + "</octal>");
			returnXml.append("\r\n<hyper>" + Integer.toString(keychar, 16) + "</hyper>");
			returnXml.append("\r\n<binary>" + Integer.toString(keychar, 2) + "</binary>");
			returnXml.append("\r\n</converted-values>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(returnXml.toString());
		} else {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("?");

		}

	}

}
