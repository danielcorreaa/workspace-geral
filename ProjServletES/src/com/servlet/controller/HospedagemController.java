package com.servlet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.HospedagemDAO;
import com.servlet.dao.QuartoDAO;
import com.servlet.modelo.Hospedagem;
import com.servlet.modelo.Quarto;

public class HospedagemController extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		HospedagemDAO dao = new HospedagemDAO();
		request.setAttribute("hospedagens", dao.getHospedagens());
		RequestDispatcher rd = request.getRequestDispatcher("CadHosp.jsp");
		rd.forward(request, response);	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HospedagemDAO dao = new HospedagemDAO();
		QuartoDAO daQuarto = new QuartoDAO();
		
		
		
		List<Quarto> quartos = daQuarto.getQuartos();
		
		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setNumeroHospedagem(Integer.parseInt(req.getParameter("numeroHospedagem")));
	    hospedagem.setQuarto(hospedagem.buscarQuarto(Integer.parseInt(req.getParameter("quarto")), quartos));
	    hospedagem.setEntrada(hospedagem.retornarData(req.getParameter("entrada")));
	    //hospedagem.setEntrada(hospedagem.retornarData(saida));
	    
	    System.out.println(Integer.parseInt(req.getParameter("numeroHospedagem")));
	    System.out.println(hospedagem.buscarQuarto(Integer.parseInt(req.getParameter("quarto")), quartos).numeroPorta);
	    System.out.println(req.getParameter("entrada"));
	    dao.getHospedagens().add(hospedagem);
	    
	    for (Hospedagem h : dao.getHospedagens()){
		   System.out.println(h.getNumeroHospedagem());
		   System.out.println(h.getQuarto().getNumeroPorta());
		   System.out.println(h.getEntrada());
		   //System.out.println(h.getSaida());
	    }
		
	}
}
