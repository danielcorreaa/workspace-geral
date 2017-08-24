package com.controle.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.controle.dao.UsuarioDAO;
import com.controle.modelo.Usuario;

public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = req.getParameter("loginCad");
		
		if(login != null){
			
			String msg = "Login já cadastro escolha outro!";
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = dao.buscarLogin(login);
			
				if(usuario != null){
					resp.setContentType("text/plain");
					resp.setHeader("Cache-Control", "no-cache");
					resp.getWriter().println(msg);
				}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id_usuario");
		String nome = req.getParameter("nome").toUpperCase();
		String login = req.getParameter("loginCad").toLowerCase();
		String senha = req.getParameter("senhaCad");
		
		Usuario usuario = new Usuario();

		if (id != null && !id.equalsIgnoreCase("")) {
			usuario.setId(Integer.parseInt(id));
		} else {
			usuario.setId(null);
		}

		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		String msg = "Salvo com Sucesso!";
		UsuarioDAO dao = new UsuarioDAO();
		try {
			dao.salvar(usuario);
		} catch (Exception ex) {
			msg = "Falha ao Salvar";
		}

		resp.setContentType("text/plain");
		resp.setHeader("Cache-Control", "no-cache");
		resp.getWriter().println(msg);
	}

}
