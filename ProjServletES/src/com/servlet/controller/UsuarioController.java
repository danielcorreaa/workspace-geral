package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.UsuarioDAO;
import com.servlet.modelo.Usuario;

public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.getUsuarios();		
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("/informacao.jsp");
		rd.forward(request, response);
	}

	
}
