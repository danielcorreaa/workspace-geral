package com.controle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.controle.dao.UsuarioDAO;
import com.controle.modelo.Usuario;

public class AutoCompleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 	
			JSONArray lista = null; //cria o array
	        String nomeUser = req.getParameter("term"); //term é o parametro enviado pelo jquery ao usar o autocomplete
	        
	        try {
	            lista = new JSONArray(); //cria o array
	            UsuarioDAO dao = new UsuarioDAO();
	            List<Usuario> listaUser = dao.buscarLoginNome(nomeUser);	            
	            System.out.println(listaUser);
	 
	            for (Usuario us: listaUser)
	            {
	                JSONObject jsonObject = new JSONObject();
	                jsonObject.put("label", us.getLogin());
	                lista.put(jsonObject);
	            }
	 
	            listaUser = null;
	            nomeUser = null;
	 
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        resp.setContentType("application/json");
	        resp.getWriter().write(lista.toString());
	 
	        lista = null;
	}
	
	
	
}
