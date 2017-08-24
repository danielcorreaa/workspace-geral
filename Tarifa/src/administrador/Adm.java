package administrador;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import modelo.Estacionamento;




public class Adm {
	
	static Locale brasil = new Locale("pt", "BR");
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm",brasil);
	
	public static void main(String[] args) throws ParseException {
		
		
		
		
		
		Estacionamento est = new Estacionamento();
		est.setNumVagas(60);
		est.setDataHoraEntrada(sdf.parse("13/10/2015 09:36"));
		
		//est.retornarDatafinal(0);
		est.setDataHoraSaida(sdf.parse("13/10/2015 11:36"));
		
		
		System.out.println(est.tempoNoEstacionamentoHoras()+" Horas");
		System.out.println(sdf.format(est.getDataHoraEntrada()));
		System.out.println(sdf.format(est.getDataHoraSaida()));
		
		
	}
	
}
