package com.controle.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controle.dao.CartaoDAO;
import com.controle.dao.CompraDAO;
import com.controle.dao.EstabelecimentoDAO;
import com.controle.dao.ProdutoDAO;
import com.controle.modelo.Cartao;
import com.controle.modelo.Compra;
import com.controle.modelo.Estabelecimento;
import com.controle.modelo.Produto;
import com.controle.modelo.Usuario;

public class CompraController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		
		CompraDAO dao = new CompraDAO();
		List<Compra> compras = dao.buscarTodosPorUsuario(usuario.getId());

		ProdutoDAO daoProd = new ProdutoDAO();
		List<Produto> produtos = daoProd.buscarTodosPorUsuario(usuario.getId());

		EstabelecimentoDAO daoEstabelecimentos = new EstabelecimentoDAO();
		List<Estabelecimento> estabelecimentos = daoEstabelecimentos.buscarTodosPorUsuario(usuario.getId());
		
		String msg = "";

		String acao = req.getParameter("acao");
		if (acao != null) {
			if (acao.equalsIgnoreCase("alterar")) {

				dao = new CompraDAO();
				Integer id = Integer.parseInt(req.getParameter("id"));
				Compra compra = dao.getPorId(id);
				req.setAttribute("compra", compra);

			} else if (acao.equalsIgnoreCase("excluir")) {

				dao = new CompraDAO();
				Integer id = Integer.parseInt(req.getParameter("id"));
				Compra compra = dao.getPorId(id);
				msg = "Excluido com Sucesso!";

				try {
					dao.excluir(compra);
				} catch (Exception ex) {
					msg = "Falhar ao Excluir" + ex.getMessage();
				}

				req.setAttribute("msg", msg);

			}
		}

		req.setAttribute("compras", compras);
		req.setAttribute("produtos", produtos);
		req.setAttribute("estabelecimentos", estabelecimentos);
		RequestDispatcher rd = req.getRequestDispatcher("/restrito/compra.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idEstabelecimento = req.getParameter("estabelecimento");
		EstabelecimentoDAO daoEstabelecimento = new EstabelecimentoDAO();
		Estabelecimento estabelecimento = daoEstabelecimento.getPorId(Integer.parseInt(idEstabelecimento));

		String idProduto = req.getParameter("produto");
		ProdutoDAO daoProd = new ProdutoDAO();
		Produto produto = daoProd.getPorId(Integer.parseInt(idProduto));

		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		
		CartaoDAO daoCard = new CartaoDAO();
		Cartao card = daoCard.buscarPorUsuario(usuario.getId());
		
		
		Compra compra = new Compra();

		String id = req.getParameter("id_compra");
		
		if (id != null && !id.equalsIgnoreCase("")) {
			compra.setId(Integer.parseInt(id));

		} else {
			compra.setId(null);
		}
		
		compra.setDataCompra(req.getParameter("data"));
		compra.setEstabelecimento(estabelecimento);
		compra.setProduto(produto);
		compra.setCartao(card);
		compra.setUsuario(usuario);
		
		String formaPagamento = req.getParameter("group1");
		if (formaPagamento != null && !formaPagamento.equalsIgnoreCase("")) {
			
			if (formaPagamento.equalsIgnoreCase("avista")) {
				
//				String dataPagamentoAvista = req.getParameter("dataPagamentoAvista");
				String valor = req.getParameter("valorAvista");
//				Calendar c = Calendar.getInstance();
//				c.setTime(compra.retornarData(dataPagamentoAvista));
				compra.pagamentoAvista(0, compra.retornarValor(valor), compra.retornarData());

			} else {
				
				String qtdeParcela = req.getParameter("qtdeParcela");
				String valor = req.getParameter("valorpar");
//				String dataPagamentoParcela = req.getParameter("dataPagamentopar");
//				Calendar c = Calendar.getInstance();
//				c.setTime(compra.retornarData(dataPagamentoParcela));
				compra.parcelarCompra(compra.retornarParcala(qtdeParcela), compra.retornarValor(valor), compra.retornarData());

			}
		}

		CompraDAO dao = new CompraDAO();
		String msg = "Salvo com Sucesso!";
		try {
			dao.salvar(compra);
		} catch (Exception ex) {
			msg = "Erro ao Salvar!";
		}

		resp.setContentType("text/xml");
		resp.setHeader("Cache-Control", "no-cache");
		resp.getWriter().write(msg);

	}

}
