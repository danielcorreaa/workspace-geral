package com.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EnderecoDAO;
import com.servlet.modelo.Endereco;

public class BuscarCepController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("ISO-8859-1");
		String cep = request.getParameter("cep");
		if (cep != null) {
			EnderecoDAO dao = new EnderecoDAO();
			Endereco end = dao.buscarPorCep(cep);
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			String texto = end.getBairro()+"-"+end.getRua()+"-"
					+end.getCidade().getNome()+"-"+end.getCidade().getEstado().getNome();
			response.getWriter().write(texto);
			
		}else{
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("");
		}

	}

}
