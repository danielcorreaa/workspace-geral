package personagem;


import java.awt.image.BufferedImage;

import leitura.LeituraArquivoImagem;



public class Cenario {
	
	private int posx, posy;
	private BufferedImage imagem;
	private int altura, largura;
	
	public Cenario() {
		super();
		imagem = LeituraArquivoImagem.lerArquivo("img/cenario1-1.png");
		
		posx = 0;
		posy = 0;
		largura = imagem.getWidth();
	}
	
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public BufferedImage getImagem() {
		return imagem;
	}
	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	
	public void mover(){
		if(posx > -2592){
			posx--;
			System.out.println(largura);
			System.out.println(posx);
		}
	}

}
