package regra;

import modelo.Tarifa;

public class Diaria implements Tarifa{
	
	
	
	public Diaria() {
		super();		
	}



	@Override
	public double CalcularPagamento(double valor, int tempo) {
		return valor * tempo;	
	}

	

}
