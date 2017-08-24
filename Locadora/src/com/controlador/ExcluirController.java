package com.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.modelo.Cliente;

public class ExcluirController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String id = request.getParameter("id");
		System.out.println(id);
		if (id != null) {
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = dao.getPorId(Integer.parseInt(id));
			System.out.println(cliente.getNome());
			try {
				dao.excluir(cliente);
				System.out.println("Sucesso!");
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write("Excluido");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	}
}
