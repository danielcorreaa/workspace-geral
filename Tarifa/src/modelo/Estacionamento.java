package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Estacionamento {
	
	private int numVagas;
	private TipoTarifa tipoTarifa;
	private Tarifa tarifa;
	private Date dataHoraEntrada;
	private Date dataHoraSaida;
	
	public Estacionamento() {
		super();		
	}
	
	public int getNumVagas() {
		return numVagas;
	}
	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}
	public TipoTarifa getTipoTarifa() {
		return tipoTarifa;
	}
	public void setTipoTarifa(TipoTarifa tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}
	
	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Date dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public int controleVagas(){
		numVagas--;
		return  numVagas;
	}
	
	
	public int tempoNoEstacionamentoHoras(){
		Calendar cEntrada = Calendar.getInstance();
		cEntrada.setTime(dataHoraEntrada);
		
		Calendar cSaida = Calendar.getInstance();
		cSaida.setTime(dataHoraSaida);
		
		long saida = (cSaida.getTimeInMillis() - cEntrada.getTimeInMillis())  / 1000 / 60 / 60;
		
		return  (int) saida;
	}
	
	public int tempoNoEstacionamentoDias(){
		Calendar cEntrada = Calendar.getInstance();
		
		cEntrada.setTime(dataHoraEntrada);
		
		Calendar cSaida = Calendar.getInstance();
		cSaida.setTime(dataHoraSaida);
		
		long saida = (cSaida.getTimeInMillis() - cEntrada.getTimeInMillis())  / 1000 / 60 / 60 /24;
		
		return (int) saida; 
	}
	
	public int tempoNoEstacionamentoMes(){
		Calendar cEntrada = Calendar.getInstance();
		cEntrada.setTime(dataHoraEntrada);
		
		Calendar cSaida = Calendar.getInstance();
		cSaida.setTime(dataHoraSaida);
		
		long saida = (cSaida.getTimeInMillis() - cEntrada.getTimeInMillis())  / 1000 / 60 / 60 /24 /30;
		
		return  (int) saida;
	}
	
	public Date retornarDatafinal(int num){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");		
		String hora = sdf.format(dataHoraEntrada);
		Date h = null;
		
		try {
			h = sdf.parse(hora);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		
		c.setTime(h);
		c.set(Calendar.HOUR_OF_DAY, num);
		System.out.println(Calendar.HOUR_OF_DAY);
		dataHoraSaida = c.getTime();
		
		return dataHoraSaida;
	}
	

	
}
