package com.controle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controle.dao.ProdutoDAO;
import com.controle.modelo.Produto;
import com.controle.modelo.Usuario;

public class ProdutoController extends HttpServlet{	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProdutoDAO dao = new ProdutoDAO();
		
		String msg ="";
		String acao = req.getParameter("acao");
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		
		if(acao!=null){
			if(acao.equalsIgnoreCase("alterar")){
				
				dao = new ProdutoDAO();
				Integer id = Integer.parseInt(req.getParameter("id"));
				Produto prod = dao.getPorId(id);
				req.setAttribute("estab", prod);
				
			}else if(acao.equalsIgnoreCase("excluir")){
				
				dao = new ProdutoDAO();
				Integer id = Integer.parseInt(req.getParameter("id"));
				Produto prod = dao.getPorId(id);
				msg = "Excluido com Sucesso!";
				
					try{
						dao.excluir(prod);
					}catch(Exception ex){
						msg ="Falhar ao Excluir"+ex.getMessage();
					}
					
				
				req.setAttribute("msg", msg);
				
			}
		}
		List<Produto> produtos = dao.buscarTodosPorUsuario(usuario.getId());
		req.setAttribute("produtos", produtos);
		RequestDispatcher rd = req.getRequestDispatcher("/restrito/produto.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		
		String id = req.getParameter("id_produto");
		String nome = req.getParameter("nome_prod").toUpperCase();
		String preco = req.getParameter("preco");
		
		Produto produto = new Produto();
		
		if(id != null && !id.equalsIgnoreCase("")){
			produto.setId(Integer.parseInt(id));			
		}else{
			produto.setId(null);
		}
		
		produto.setNomeProd(nome.toUpperCase());
		produto.setPreco(Double.parseDouble(preco));
		if(usuario!=null){
			produto.setUsuario(usuario);
		}
		String msg = "Salvo com Sucesso!";		
		ProdutoDAO dao = new ProdutoDAO();		
		try{
			dao.salvar(produto);
			}catch(Exception ex){
			msg = "Falha ao Salvar";
		}
		
		
		resp.setContentType("text/xml");
		resp.setHeader("Cache-Control", "no-cache");
		resp.getWriter().write(msg);
	}

}
