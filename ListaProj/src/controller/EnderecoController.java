package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Endereco;

import daoDB.EnderecoDAO;

/**
 * Servlet implementation class EnderecoController
 */
public class EnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnderecoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnderecoDAO dao = new EnderecoDAO();
		List<Endereco> ends = dao.getBanco();
		
		String acao = request.getParameter("acao");
		if(acao!=null){
			if(acao.equalsIgnoreCase("excluir")){
				dao = new EnderecoDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Endereco e = dao.buscarPorId(id);
				dao.excluir(e);
				ends = dao.getBanco();
			}else if(acao.equalsIgnoreCase("alterar")){
				dao = new EnderecoDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Endereco e = dao.buscarPorId(id);
				request.setAttribute("endereco", e);
				
			}
		}
		
		
		request.setAttribute("enderecos", ends);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	EnderecoDAO dao = new EnderecoDAO();
	Endereco endereco = new Endereco();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		endereco.setRua(request.getParameter("rua"));
		endereco.setNumero(request.getParameter("numero"));
		
		
		String msg="Salvo com Sucesso";
		try{
		  dao.salvar(endereco);		 
		}catch (Exception e) {
		  msg = "Erro ao Salvar";	
		}
		
		dao.salvar(endereco);
		List<Endereco> ends = dao.getBanco();
		
		request.setAttribute("enderecos", ends);
		request.setAttribute("mensagem", msg);
		RequestDispatcher rd = 
			
            request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
	}

}
