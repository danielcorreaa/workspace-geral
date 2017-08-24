package com.controle.adm;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;

import javax.persistence.Persistence;








public class Controle {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("cartao");
	}

	// Persistence.createEntityManagerFactory("cartao");
	public static Date setData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data1;
		try {
			data1 = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			data1 = new Date();
		}
		return data1;
	}

	public static String getData(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

}
