package regra;

import modelo.Tarifa;

public class Horista implements Tarifa{
	
	
	public Horista() {
		super();		
	}


	@Override
	public double CalcularPagamento(double valor, int tempo) {
		return valor * tempo;	
	}

}
