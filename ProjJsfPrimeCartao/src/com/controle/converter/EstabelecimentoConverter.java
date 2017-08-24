package com.controle.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.controle.dao.EstabelecimentoDAO;
import com.controle.modelo.Estabelecimento;

@FacesConverter("EstabelecimentoConverter")
public class EstabelecimentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) throws ConverterException {
		EstabelecimentoDAO dao = new EstabelecimentoDAO();
		Estabelecimento estabelecimento = dao.getPorId(Integer.parseInt(id));
		return estabelecimento;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) throws ConverterException {		
		return String.valueOf(((Estabelecimento) obj ).getId());
	}
	
}
