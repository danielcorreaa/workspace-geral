package com.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.modelo.Cliente;

/**
 * Servlet implementation class ListCliente
 */
public class ListCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Cliente> clientes = null;
		ClienteDAO dao = new ClienteDAO();
		clientes = dao.listar();

		String acao = request.getParameter("acao");

		if (acao != null) {
			if (acao.equalsIgnoreCase("excluir")) {
				dao = new ClienteDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Cliente cli = dao.getPorId(id);
				dao.excluir(cli);
				clientes = dao.listar();
			}
		}

		int begin = 0;
		int end = 9;
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.setAttribute("lista", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("/cliente");
		rd.forward(request, response);
	}

}
