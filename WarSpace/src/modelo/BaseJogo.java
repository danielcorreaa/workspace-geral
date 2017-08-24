package modelo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import animacoes.Explosao;

public abstract class BaseJogo {

	protected BufferedImage imagem;
	protected int x, y;
	protected int altura, largura;
	protected boolean visivel;
	protected int dx, dy;
	private Explosao explosao;
	
	public BaseJogo() {
		super();
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
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

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
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
	
	
	
	public Explosao getExplosao() {
		return explosao;
	}

	public void setExplosao(Explosao explosao) {
		this.explosao = explosao;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, altura, largura);
	} 
	public abstract void  mover();
	
}
