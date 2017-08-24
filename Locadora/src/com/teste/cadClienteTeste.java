package com.teste;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dao.AutorizacaoDAO;
import com.dao.ClienteDAO;
import com.dao.FilmeDAO;
import com.dao.LocacaoDAO;
import com.dao.UsuarioDAO;
import com.modelo.AlugarFilme;
import com.modelo.Autorizacao;
import com.modelo.Cliente;
import com.modelo.Filme;
import com.modelo.Locacao;
import com.modelo.Usuario;

public class cadClienteTeste {
	
    public static void main(String[] args) {
	
    	AutorizacaoDAO adao = new AutorizacaoDAO();
    	Autorizacao aut = new Autorizacao();
    	aut.setNome("ROLE_USER");
    	
    	Autorizacao aut2 = new Autorizacao();
    	aut2.setNome("ROLE_ADMIN");
    	
    	adao.inserir(aut);
    	adao.inserir(aut2);
    	
    
    	
    	UsuarioDAO dao = new UsuarioDAO();
    	
    	Usuario user = new Usuario();
    	user.setEnable(true);
    	user.setUsername("admin");
    	user.setPassword("admin");
    	user.setAutorizacoes(new ArrayList<>());
    	user.getAutorizacoes().add(aut);
    	
    	System.out.println(dao.inserir(user));;
    	
    
    	
    	
    	
    }

	
}
