package com.controlador;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.dao.FilmeDAO;

import com.modelo.Filme;

/**
 * Servlet implementation class FilmeControle
 */
public class FilmeControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmeControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		FilmeDAO dao = new FilmeDAO();
		List<Filme> filmes = dao.listar();
		
		String acao = request.getParameter("acao");

		if (acao != null) {
			if (acao.equalsIgnoreCase("excluir")) {
				dao = new FilmeDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Filme f = dao.getPorId(id);
				String msg = "Excluído com Sucesso!";
				try{
				     dao.excluir(f);
				}catch(Exception e){
					 msg = "Falha ao Excluir! "+e.getMessage();	
				}
				request.setAttribute("msgex", msg);
				filmes = dao.listar();
			} else if (acao.equalsIgnoreCase("alterar")) {
				dao = new FilmeDAO();
				Integer id = Integer.parseInt(request.getParameter("id"));
				Filme f = dao.getPorId(id);
				Filme c = f;
				request.setAttribute("fil", c);			
				
				
			}
		}
		
		request.setAttribute("listaFilmes", filmes);
		RequestDispatcher rd = request.getRequestDispatcher("/filme.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ok = null;
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(request);   
                 while (itr.hasNext()) {
                        FileItemStream item = itr.next();   
                        String path = getServletContext().getRealPath("/");
                        if (Filme.processFile(path, item)) 
                         ok = "Imagem enviada Com sucesso";   
                         else 
                         ok = "Falha ao enviar a imagem";
                      
                    
                }
            } catch (FileUploadException fue) {
                fue.printStackTrace();
            }
        
        }
	       
    	    String acao = request.getParameter("acao");
    	    System.out.println(acao);
			if(acao!= null){
				if(acao.equalsIgnoreCase("Salvar")){
			        Filme f = new Filme();
					
					try{
						f.setId(Integer.parseInt(request.getParameter("idfil")));
					}catch(Exception ex){
						f.setId(null);
					}
					f.setImg(request.getParameter("caminhoImg"));
					f.setTitulo(request.getParameter("titulo"));
					f.setPreco(Double.parseDouble(request.getParameter("preco")));
					f.setDisponivel(true);
			
					FilmeDAO dao = new FilmeDAO();
					String msg = "Salvo com Sucesso!";
					try {
						dao.salvar(f);
					} catch (Exception ex) {
						msg = "Erro ao Salvar" + ex.getMessage();
					}
					request.setAttribute("mensagem", msg);
			
					List<Filme> filmes = null;
					dao = new FilmeDAO();
					filmes = dao.listar();
					request.setAttribute("listaFilmes", filmes);
				}
			}
	
        request.setAttribute("up", ok);
		RequestDispatcher rd = request.getRequestDispatcher("/filme.jsp");
		rd.forward(request, response);
	}
	

}
