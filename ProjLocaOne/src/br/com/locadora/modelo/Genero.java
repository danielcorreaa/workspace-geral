package br.com.locadora.modelo;

public enum Genero {

	ACAO (1, "A��o"), 
	TERROR (2 , "Terror (ou horror)"),
	ANIMACAO (3, "Anima��o"),
	AVENTURA (4, "Aventura"),
	CINAMECATASTROFE (5, "Cinema cat�strofe"),
	COMEDIA (6,"Com�dia"),
	COMEDIAROMANTICA (7,"Com�dia rom�ntica"),
	COMEDIADRAMATICA (8,"Com�dia dram�tica"),
	COMEDIAACAO (9,"Com�dia de a��o"),
	CULT (10, "Cult"),
	DANCA (11, "Dan�a"),
	DOCUMENTARIOS (12, "Document�rios"),
	DRAMA (13, "Drama"),
	ESPIONAGEM (14, "Espionagem"),
	FAROESTE (15,"Faroeste (ou western)"),
	FICCAOCIENTIFICA (16,"Fic��o cient�fica"),
	GUERRA (17, "Guerra"),
	ROMANCE (18,"Romance"),
	SUSPENSE (19,"Suspense"),
	POLICIAL(20, "Policial"),
	TRASH(21,"Trash");
	
	
	private int codigo;
	private String descricao;
	
	private Genero(int codigo, String descricao) {
		this.descricao = descricao;
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
}
