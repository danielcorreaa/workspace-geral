package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.google.gson.Gson;
import com.modelo.Cliente;

@SuppressWarnings("serial")
public class ClienteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String category = req.getParameter("category");
		 List<Cliente> cli = new ArrayList<>();
		 ClienteDAO dao = null;
		 
		 //if (category.equalsIgnoreCase("serial")) {
			 dao = new ClienteDAO();
			 for(Cliente c : dao.getClientes()){
				 System.out.println(c);
				 cli.add(c);
			 }
			 			
		 //}
		 
		 String json = new Gson().toJson(cli);
		 System.out.println(json);
         resp.setContentType("application/json");
         resp.getWriter().write(json);
		 
	}
	
}
