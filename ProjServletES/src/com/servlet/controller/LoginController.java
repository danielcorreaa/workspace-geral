package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.servlet.dao.UsuarioDAO;
import com.servlet.modelo.Usuario;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// para logar
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");		
		String msg = "";
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarSenha(senha);
		if (usuario == null ||  !usuario.getLogin().equalsIgnoreCase(login)) {
			msg = "Usuário e Senha Incorretos";
			request.setAttribute("ok", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} else if (usuario.logar(usuario.getSenha()) && usuario != null && usuario.getLogin().equalsIgnoreCase(login)) {

			HttpSession session = request.getSession();
			session.setAttribute("user", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		}

	}

}
