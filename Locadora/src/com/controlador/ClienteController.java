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
import com.sun.org.apache.bcel.internal.generic.GOTO;

/**
 * Servlet implementation class ClienteController
 */
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteController() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
				String msg = "Excluído com Sucesso!";
				try{
				     dao.excluir(cli);
				}catch(Exception e){
					 msg = "Falha ao Excluir! "+e.getMessage();	
				}
				request.setAttribute("msgex", msg);
				clientes = dao.listar();
			} else if (acao.equalsIgnoreCase("alterar")) {
				dao = new ClienteDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Cliente cli = dao.getPorId(id);
				Cliente c = cli;
				request.setAttribute("clie", c);
			}
		}
		
		
		
		request.setAttribute("listaCliente", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("/cliente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Cliente cli = new Cliente();
		
		try{
			cli.setId(Integer.parseInt(request.getParameter("idcli")));
		}catch(Exception ex){
			cli.setId(null);
		}
		cli.setNome(request.getParameter("nome"));
		cli.setCpf(request.getParameter("cpf"));
		cli.setTelefone(request.getParameter("telefone"));
		cli.setEndereco(request.getParameter("endereco"));
		cli.setAtivo(false);
		ClienteDAO dao = new ClienteDAO();
		String msg = "Salvo com Sucesso!";
		try {
			dao.salvar(cli);
		} catch (Exception ex) {
			msg = "Erro ao Salvar" + ex.getMessage();
		}
		request.setAttribute("msg", msg);

		List<Cliente> clientes = null;
		dao = new ClienteDAO();
		clientes = dao.listar();
		request.setAttribute("listaCliente", clientes);

		RequestDispatcher rd = request.getRequestDispatcher("/cliente.jsp");
		rd.forward(request, response);
	}

}
