package com.strategy.modelo;

public class TarifaSedex implements Tarifa{

	@Override
	public double calcular() {
		return 10 * 2 + 2;
	}

}
