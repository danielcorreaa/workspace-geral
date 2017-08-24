package com.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.servlet.modelo.Usuario;

public class UsuarioDAO {
	
	private List<Usuario> usuarios;

	public UsuarioDAO() {
		super();
		usuarios = new ArrayList<>();
		povoarBanco();
	}

	private void povoarBanco() {
		Usuario user1 = new Usuario();
		user1.setNome("Zé Comeia");
		user1.setLogin("ze");
		user1.setSenha("ze");
		user1.setIdade(40);
		
		Usuario user2 = new Usuario();
		user2.setNome("Doug Funny");
		user2.setLogin("doug");
		user2.setSenha("doug");
		user2.setIdade(12);
		
		Usuario user3 = new Usuario();
		user3.setNome("Homer Simpson");
		user3.setLogin("homer");
		user3.setSenha("homer");
		user3.setIdade(35);
		
		Usuario user4 = new Usuario();
		user4.setNome("Kevin Arnold");
		user4.setLogin("kevin");
		user4.setSenha("kevin");
		user4.setIdade(17);
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
		usuarios.add(user4);
		
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario buscarSenha(String senha){
		for(Usuario us: getUsuarios()){
			if(us.getSenha().equalsIgnoreCase(senha)){
				return us;
			}
		}
		return null;
	}
	

}
