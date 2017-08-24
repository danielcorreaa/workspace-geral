package com.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.ClienteDAO;

public class ValidacaoNomeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setCharacterEncoding("ISO-8859-1");
		String nome = request.getParameter("nome");
		
		if(nome!= null && nome.length()>0){
			ClienteDAO dao = new ClienteDAO();
			boolean nomeExiste = dao.buscarPorNome(nome);
			if(nomeExiste){
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write("Esse nome já foi Cadastrado no Sistema");
			}else{
				response.getWriter().write("Valido");
			}
		}
		
	}
	
}
