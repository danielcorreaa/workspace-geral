package com.controle.rn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PesquisarFatura {
	

	public static Date inicioMes(String mes, String ano) {
		String dataParaFormatar = "";
		Date dataInicioMes = null;
		if (mes.equalsIgnoreCase("Janeiro")) {
			dataParaFormatar = "01/01/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Fevereiro")) {
			dataParaFormatar = "01/02/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Março")) {
			dataParaFormatar = "01/03/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Abril")) {
			dataParaFormatar = "01/04/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Maio")) {
			dataParaFormatar = "01/05/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Junho")) {
			dataParaFormatar = "01/06/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Julho")) {
			dataParaFormatar = "01/07/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Agosto")) {
			dataParaFormatar = "01/08/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Setembro")) {
			dataParaFormatar = "01/09/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Outubro")) {
			dataParaFormatar = "01/10/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Novembro")) {
			dataParaFormatar = "01/11/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Dezembro")) {
			dataParaFormatar = "01/12/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		}
		return dataInicioMes;
	}
	
	public static Date fimMes(String mes, String ano) {
		String dataParaFormatar = "";
		Date dataInicioMes = null;
		if (mes.equalsIgnoreCase("Janeiro")) {
			dataParaFormatar = "31/01/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Fevereiro")) {
			dataParaFormatar = "28/02/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Março")) {
			dataParaFormatar = "31/03/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Abril")) {
			dataParaFormatar = "30/04/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Maio")) {
			dataParaFormatar = "31/05/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Junho")) {
			dataParaFormatar = "30/06/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Julho")) {
			dataParaFormatar = "31/07/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Agosto")) {
			dataParaFormatar = "31/08/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Setembro")) {
			dataParaFormatar = "30/09/" + ano;			
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Outubro")) {
			dataParaFormatar = "31/10/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Novembro")) {
			dataParaFormatar = "30/11/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		} else if (mes.equalsIgnoreCase("Dezembro")) {
			dataParaFormatar = "31/12/" + ano;
			dataInicioMes = retornarData(dataParaFormatar);
		}
		return dataInicioMes;
	}

	public static Date retornarData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
}
