package com.controle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controle.dao.CompraDAO;
import com.controle.modelo.Compra;
import com.controle.rn.PesquisarFatura;


public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/restrito/index.jsp");
		rd.forward(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mes = req.getParameter("mes");
		List<Compra> compras;
		if(mes!=null){
			CompraDAO dao = new CompraDAO();		
			compras = dao.buscarComprasMes(PesquisarFatura.inicioMes(mes,"2015"), PesquisarFatura.fimMes(mes, "2015"));			
			req.setAttribute("compras", compras);
		}else{
			System.out.println("erro");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/restrito/index.jsp");
		rd.forward(req,resp);
	}
	
}
