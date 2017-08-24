package br.com.locadora.modelo;

public enum Genero {

	ACAO (1, "Ação"), 
	TERROR (2 , "Terror (ou horror)"),
	ANIMACAO (3, "Animação"),
	AVENTURA (4, "Aventura"),
	CINAMECATASTROFE (5, "Cinema catástrofe"),
	COMEDIA (6,"Comédia"),
	COMEDIAROMANTICA (7,"Comédia romântica"),
	COMEDIADRAMATICA (8,"Comédia dramática"),
	COMEDIAACAO (9,"Comédia de ação"),
	CULT (10, "Cult"),
	DANCA (11, "Dança"),
	DOCUMENTARIOS (12, "Documentários"),
	DRAMA (13, "Drama"),
	ESPIONAGEM (14, "Espionagem"),
	FAROESTE (15,"Faroeste (ou western)"),
	FICCAOCIENTIFICA (16,"Ficção científica"),
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
