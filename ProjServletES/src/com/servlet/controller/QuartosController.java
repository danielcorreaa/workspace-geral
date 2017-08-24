package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.QuartoDAO; 

public class QuartosController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
    //exibe todos os quartos na pagina reserva.jsp
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		QuartoDAO dao = new QuartoDAO();
		request.setAttribute("quartos", dao.getQuartos());
		RequestDispatcher rd = request.getRequestDispatcher("reserva.jsp");
		rd.forward(request, response);		
		
	}

}
