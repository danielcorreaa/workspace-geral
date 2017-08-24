package com.controle.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import com.controle.dao.UsuarioDAO;
import com.controle.modelo.Usuario;

@ManagedBean(name="loginControle")
@ViewScoped
public class LoginControle implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	private Usuario usuario;

	public LoginControle() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String logar(){
		
		UsuarioDAO  dao = new UsuarioDAO();
		usuario = dao.buscarUsuario(login, senha);
		
		if(usuario!=null){
			System.out.println(login);
			System.out.println(senha);
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("user", usuario);
			return "/restrito/index.xhtml";			
		}
		
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage("Falha", new FacesMessage("Login ou Senha Incorretos!"));
		return "/error.xhtml";
	}
	
	
	public void salvar(){
		System.out.println("teste");
	}
	
}
