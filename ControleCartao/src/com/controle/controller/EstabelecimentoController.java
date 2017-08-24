package com.controle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.controle.dao.EstabelecimentoDAO;
import com.controle.modelo.Estabelecimento;
import com.controle.modelo.Usuario;
import com.google.gson.Gson;


public class EstabelecimentoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String category = req.getParameter("category");
			
			List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
			
			EstabelecimentoDAO dao = null;
			
			System.out.println(category);
			
			if (category.equalsIgnoreCase("serial")) {
				 dao = new EstabelecimentoDAO();
				 for(Estabelecimento e : dao.listar()){
					 System.out.println(e);
					 estabelecimentos.add(e);
				 }
				 			
			}
			 
			 String json = new Gson().toJson(estabelecimentos);
			 System.out.println(json);
	         resp.setContentType("application/json");
	         resp.getWriter().write(json);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EstabelecimentoDAO dao = new EstabelecimentoDAO();

		String id = req.getParameter("id_estabelecimento");

		String nome = req.getParameter("name").toUpperCase();
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");

		Estabelecimento estcimento = new Estabelecimento();

		if (id != null && !id.equalsIgnoreCase("")) {
			estcimento.setId(Integer.parseInt(id));
		} else {
			estcimento.setId(null);
		}
		if(usuario!=null){
			estcimento.setUsuario(usuario);
		}
		estcimento.setNomeEstabelecimento(nome);
		String msg = "Salvo com Sucesso!";

		try {
			dao.salvar(estcimento);
		} catch (Exception ex) {
			msg = "Falha ao Salvar";
		}

		resp.setContentType("text/xml");
		resp.setHeader("Cache-Control", "no-cache");
		resp.getWriter().write(msg);

	}

}
