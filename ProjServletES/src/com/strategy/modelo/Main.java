package com.strategy.modelo;

public class Main {
	
	public static void main(String args[]){
			
		String cpf = "35008973479";
		//String valCpf = "";
		int aculmA = 0;
		int aculmB = 0;
		int y = 8;
		for (int i = 0; i < 9; i++) {
			aculmA += (i + 1) *  cpf.charAt(i);
		}
		for (int i = 0; i < 9; i++) {
			aculmB += (i + 1) * cpf.charAt(y);
			y--;
		}
		System.out.println(aculmA);
		System.out.println(aculmB);
		if (cpf.length() == 11) {
			if (aculmA % 11 == cpf.charAt(9) && aculmB % 11 == cpf.charAt(10)) {
				System.out.println("Cof Valido");
			} else {
				System.out.println("Cpf Invalido");
				
			}
		}

		
	}
	
	public static void ola(String ...ola){
		System.out.println("Teste "+ola[0] + ola[1]);
	}
}
