package com.controle.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.controle.dao.ProdutoDAO;
import com.controle.modelo.Produto;
@FacesConverter("ProdutoConverter")
public class ProdutoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uc, String id) throws ConverterException {
		ProdutoDAO dao = new ProdutoDAO();		
		Produto prod = dao.getPorId(Integer.parseInt(id));	
		return prod;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uc, Object obj) throws ConverterException {		
		return String.valueOf(((Produto) obj).getId());
	}

}
