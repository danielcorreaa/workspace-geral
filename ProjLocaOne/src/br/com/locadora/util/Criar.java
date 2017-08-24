package br.com.locadora.util;

import javax.persistence.Persistence;

public class Criar {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("proj_loca_one");
		
	}

}
