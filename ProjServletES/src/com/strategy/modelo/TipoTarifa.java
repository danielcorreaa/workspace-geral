package com.strategy.modelo;



public enum TipoTarifa {
	
	NORMAL{
		public Tarifa getTarifa(){
		   return new TarifaNormal();
		}
	},
	
	SEDEX{
	    public Tarifa getTarifa(){
			return new TarifaSedex();
		}
	};
	
	public abstract Tarifa getTarifa();
	
}
