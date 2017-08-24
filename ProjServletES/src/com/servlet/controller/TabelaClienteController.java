package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.ClienteDAO;

public class TabelaClienteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ClienteDAO dao = new ClienteDAO();
		request.setAttribute("clientes", dao.povoarCliente());
		RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
		rd.forward(request, response);
	}
	
	
}
