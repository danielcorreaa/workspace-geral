package com.controle.rn;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilMensagem {
	
	public static void msgSucesso(String info, String msg){
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, info, msg);
		fc.addMessage(null, fm);
	}
	public static void msgErro(String info, String msg){
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, info, msg);
		fc.addMessage(null, fm);
	}

}
