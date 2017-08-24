package com.controlador;

import java.io.IOException;
import java.io.InputStream;

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
 * Servlet implementation class FileUpLoad
 */
public class FileUpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
        String msg=null;
        boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
        if (isMultiPart) {
        	System.out.println("Entrou");
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(req);
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (item.isFormField()) {
                    	System.out.println("Entrou2");
                        //String fieldNames = item.getFieldName();
                        InputStream is = item.openStream();
                        byte[] b = new byte[is.available()];
                        is.read(b);

                        //String value = new String(b);

                    } else {
                    	System.out.println("Entrou3");
                        String path = getServletContext().getRealPath("/");
                        if (Filme.processFile(path, item)) {

                            msg = "Arquivo e enviado com sucesso";
                            System.out.println("Enviiou");
                        } else {
                            msg = "Falha ao enviar";
                            System.out.println("Não Enviiou");
                        }
                       
                    }
                }
            } catch (FileUploadException fue) {
                fue.printStackTrace();
            }
            req.setAttribute("msgAcao", msg);
            RequestDispatcher visao
                    = req.getRequestDispatcher("/filme.do");
            visao.forward(req, resp);
        }

	}

}
