package com.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;

import com.dao.FilmeDAO;
import com.modelo.Filme;

/**
 * Servlet implementation class PesquisarControle
 */
public class PesquisarControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object principal = SecurityContextHolder.getContext()
			     .getAuthentication().getPrincipal();
		HttpSession session = request.getSession(true); 
		session.setAttribute("userDetails", principal);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FilmeDAO dao = new FilmeDAO();
		String titulo = request.getParameter("titulo");		
		List<Filme> filmes = dao.pesquisar(titulo);
		
		Object principal = SecurityContextHolder.getContext()
			     .getAuthentication().getPrincipal();
		HttpSession session = request.getSession(true); 
		session.setAttribute("userDetails", principal);
		
		request.setAttribute("list", filmes);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	}

}
