package com.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.modelo.Filme;

/**
 * Servlet implementation class UpLoadImg
 */
public class UpLoadImg extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public UpLoadImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setAttribute("up", ok);
        RequestDispatcher visao = request.getRequestDispatcher("filme.jsp");
        visao.forward(request, response);
	}

}
