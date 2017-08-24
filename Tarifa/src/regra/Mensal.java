package regra;

import modelo.Tarifa;

public class Mensal implements Tarifa{
	
	
	public Mensal() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public double CalcularPagamento(double valor, int tempo) {		
		return valor*tempo;
	}	

}
