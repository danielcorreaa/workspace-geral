package modelo;

import regra.Diaria;
import regra.Horista;
import regra.Mensal;

public enum TipoTarifa {
	
	HORISTA{
		@Override
		public Tarifa retornarFormaPagamento() {			
			return new Horista();
		}
	},
	
	DIARIA{
		@Override
		public Tarifa retornarFormaPagamento() {			
			return new Diaria();
		}
	},
	
	MENSAL{
		@Override
		public Tarifa retornarFormaPagamento() {			
			return new Mensal();
		}
	};
	
	public abstract Tarifa retornarFormaPagamento();
}
