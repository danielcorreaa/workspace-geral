package com.strategy.modelo;

public class TarifaNormal implements Tarifa{

	@Override
	public double calcular() {		
		return 5 * 2 + 2;
	}

}
