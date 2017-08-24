package com.controle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controle.dao.UsuarioDAO;
import com.controle.modelo.Usuario;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("user");
		String senha = req.getParameter("senha");
		String msg = "";
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarUsuario(login, senha);
		
		if (usuario != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", usuario);
			RequestDispatcher rd; 
			if (usuario.getCartoes().isEmpty()) {
				rd = req.getRequestDispatcher("/restrito/cartao.jsp");
			}else{
				rd = req.getRequestDispatcher("/restrito/index.jsp");
			}
			rd.forward(req, resp);

		} else {
			msg = "Usuário e Senha Incorretos";
			req.setAttribute("msg", msg);
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);

		}
		
	}

}
