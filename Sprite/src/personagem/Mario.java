package personagem;

import java.awt.image.BufferedImage;


public class Mario {
	
	private int x , y , altura, largura;
	private BufferedImage imagem;
	private int dx, dy;
	
	public Mario() {
		super();
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
	public BufferedImage getImagem() {
		return imagem;
	}
	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	
	
}
