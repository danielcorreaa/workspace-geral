package com.servlet.adm;

public class Administrador {

	public static void main(String[] args) {

		int qtd = 100000;

		long inicio = System.currentTimeMillis();
		concatenaString(qtd);
		long fim = System.currentTimeMillis();
		System.out.println("Classe String <=========>");
		System.out.println("Tempo total de processamento: " + (fim - inicio) + " ms");

		inicio = System.currentTimeMillis();
		concatenaStringBuffer(qtd);
		fim = System.currentTimeMillis();
		System.out.println("Classe StringBuffer <=========>");
		System.out.println("Tempo total de processamento: " + (fim - inicio) + " ms");

		inicio = System.currentTimeMillis();
		concatenaStringBuider(qtd);
		fim = System.currentTimeMillis();
		System.out.println("Classe StringBuider <=========>");
		System.out.println("Tempo total de processamento: " + (fim - inicio) + " ms");

	}

	private static void concatenaStringBuider(int qtd) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < qtd; i++) {
			s.append("a");
		}

	}

	private static void concatenaStringBuffer(int qtd) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < qtd; i++) {
			s.append("a");
		}
	}

	private static void concatenaString(int qtd) {		
		String s = "";
		for (int i = 0; i < qtd; i++) {
			s = s + "a";
		}
	}

}
