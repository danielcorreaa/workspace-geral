package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.ClienteDAO;
import com.servlet.dao.EnderecoDAO;
import com.servlet.modelo.Cliente;
import com.servlet.modelo.Endereco;

public class SalvarClienteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ClienteDAO dao = new ClienteDAO();
		request.setAttribute("clientes", dao.povoarCliente());
		RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
		rd.forward(request, response);
	}
	
	List<Cliente> clientes = new ArrayList<>();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String cep = request.getParameter("cep");
		EnderecoDAO daoe = new EnderecoDAO();
		List<Endereco> enderecos = daoe.getEnderecos();
		ClienteDAO dao = new ClienteDAO();
		
		Cliente cli = new Cliente();
		cli.setNome(request.getParameter("nome"));
		cli.setTelefone(request.getParameter("telefone"));
		cli.setCpf(request.getParameter("cpf"));
		cli.setEndereco(cli.buscarEndereco(enderecos, cep));
		clientes.add(cli);

		
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
		rd.forward(request, response);

	}

}
