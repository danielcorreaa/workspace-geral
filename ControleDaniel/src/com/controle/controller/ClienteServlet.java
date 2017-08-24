package com.controle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controle.dao.ProdutoDAO;
import com.controle.modelo.Produto;
import com.google.gson.Gson;


@SuppressWarnings("serial")
public class ClienteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		String category = req.getParameter("category");
		 List<Produto> cli = new ArrayList<>();
		 ProdutoDAO dao = null;
		 System.out.println(category);
		 if (category.equalsIgnoreCase("serial")) {
			 dao = new ProdutoDAO();
			 for(Produto c : dao.listar()){
				 System.out.println(c);
				 cli.add(c);
			 }
			 			
		 }
		 
		 String json = new Gson().toJson(cli);
		 System.out.println(json);
         resp.setContentType("application/json");
         resp.getWriter().write(json);
		 
	}
	
}
