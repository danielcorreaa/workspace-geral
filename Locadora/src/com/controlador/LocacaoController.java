package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.dao.FilmeDAO;
import com.dao.LocacaoDAO;
import com.modelo.AlugarFilme;
import com.modelo.Cliente;
import com.modelo.Filme;
import com.modelo.Locacao;

/**
 * Servlet implementation class LocacaoController
 */
public class LocacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocacaoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	List<Filme> listFilme;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		FilmeDAO dao = new FilmeDAO();
		List<Filme> filmes = dao.listar();

		List<Cliente> clientes = null;
		ClienteDAO daoC = new ClienteDAO();
		clientes = daoC.listar();
		listFilme = new ArrayList<>();

		LocacaoDAO daoLoc = new LocacaoDAO();
		List<Locacao> locacoes = daoLoc.listar();

		request.setAttribute("listaCliente", clientes);
		request.setAttribute("listaFilmes", filmes);

		String acao = request.getParameter("acao");

		if (acao != null) {
			if (acao.equalsIgnoreCase("excluir")) {
				daoLoc = new LocacaoDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Locacao l = daoLoc.getPorId(id);
				String msg = "Excluído com Sucesso!";
				try{
				   daoLoc.excluir(l);
				}catch(Exception ex){
				   msg = "Falha ao Excluir! "+ex.getMessage();	
				}
				request.setAttribute("msgex", msg);
				locacoes = daoLoc.listar();
			} else if (acao.equalsIgnoreCase("alterar")) {
				daoLoc = new LocacaoDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Locacao l = daoLoc.getPorId(id);

				clientes = new ArrayList<>();
				clientes.add(l.getCliente());
				
				for(AlugarFilme af: l.getAlugueis()){
					listFilme.add(af.getFilme());
				}
				request.setAttribute("listFilme", listFilme);
				request.setAttribute("listaCliente", clientes);
				
				request.setAttribute("locacao", l);
			}
		}

		request.setAttribute("locacoes", locacoes);
		RequestDispatcher rd = request.getRequestDispatcher("/locacao.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String acao = request.getParameter("acao");
		System.out.println(acao);
		FilmeDAO dao = new FilmeDAO();
		if (acao == null) {

			String codFilme = request.getParameter("fi");

			Filme filme = dao.getPorId(Integer.parseInt(codFilme));
			if (!listFilme.contains(filme)) {

				listFilme.add(filme);
			}

			PrintWriter out = response.getWriter();

			for (Filme fil : listFilme) {

				out.println(fil.getTitulo());

			}

		} else if (acao != null) {
			if (acao.equalsIgnoreCase("salvar")) {
				ClienteDAO daoCliente = new ClienteDAO();
				Locacao loc = new Locacao();
				LocacaoDAO daoLoca = new LocacaoDAO();
				String id = request.getParameter("Cliente");
				
				Cliente cliente = daoCliente.getPorId(Integer.parseInt(id));
				cliente.setAtivo(true);
				daoCliente.salvar(cliente);

				
				
				try {
					loc.setId(Integer.parseInt(request.getParameter("idloc")));
				} catch (Exception e) {
					loc.setId(null);
				}
				loc.setCliente(cliente);
				loc.setSaida(request.getParameter("saida"));
				loc.setDevolucaoPrev(request.getParameter("devoprev"));

				for (Filme f : listFilme) {
					f.setDisponivel(false);
					dao.salvar(f);
				}
				loc.alugar(listFilme);
				String msg = "Salvo com Sucesso!";
				
				try{
				   daoLoca.salvar(loc);
				}catch(Exception e){
				   msg = "Erro ao Salvar "+e.getMessage();	
				}
				
			    dao = new FilmeDAO();
				List<Filme> filmes = dao.listar();

				List<Cliente> clientes = null;
				ClienteDAO daoC = new ClienteDAO();
				clientes = daoC.listar();
				listFilme = new ArrayList<>();

				LocacaoDAO daoLoc = new LocacaoDAO();
				List<Locacao> locacoes = daoLoc.listar();

				request.setAttribute("listaCliente", clientes);
				request.setAttribute("listaFilmes", filmes);
				request.setAttribute("locacoes", locacoes);
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request.getRequestDispatcher("/locacao.jsp");
				rd.forward(request, response);
			}

		}

	}

}
