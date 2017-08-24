package com.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.ClienteDAO;
import com.servlet.modelo.Cliente;

public class RemoverClienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String nome = request.getParameter("nome");
		if (nome != null) {
			ClienteDAO dao = new ClienteDAO();
			Cliente cli = dao.buscarCliente("Kelly Leblock");

			System.out.println(cli.getNome());

			dao.getClientes().remove(cli);

			System.out.println(cli.getNome());

		}

	}

}
