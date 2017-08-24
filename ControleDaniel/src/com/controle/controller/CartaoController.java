package com.controle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controle.dao.CartaoDAO;
import com.controle.modelo.Cartao;
import com.controle.modelo.Usuario;

public class CartaoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/restrito/cartao.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id_cartao").toUpperCase();
		String bandeira = req.getParameter("bandeira");
		String limite = req.getParameter("limite");
		String msg = "Salvo com Sucesso";
		
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		
		
		//System.out.println("Nomeeeeeeeeeeeeeeeee "+usuario.getLogin());
		
		Cartao cartao = new Cartao();
		if(id!=null && !id.equalsIgnoreCase("")){
			cartao.setId(Integer.parseInt(id));
		}else{
			cartao.setId(null);
		}
		cartao.setBandeira(bandeira);
		cartao.setLimite(Double.parseDouble(limite));
		cartao.setUsuario(usuario);
		
		CartaoDAO dao = new CartaoDAO();
		try{
			dao.salvar(cartao);
		}catch(Exception ex){
			msg = "Erro ao Salvar";
		}
		
		resp.setContentType("text/xml");
		resp.setHeader("Cache-Control", "no-cache");
		resp.getWriter().write(msg);
	}

}
