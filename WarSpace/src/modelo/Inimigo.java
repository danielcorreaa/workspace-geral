package modelo;

import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import animacoes.ExplosaoInimigo;

public class Inimigo extends BaseJogo implements Runnable {

	private Thread tempo;
	private boolean atingida;
	boolean continuar;

	public Inimigo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		visivel = true;
		tempo = new Thread(this);
		atingida = false;
		lerInimigo();
		correrTempo();

	}

	public boolean isAtingida() {
		return atingida;
	}

	public void setAtingida(boolean atingida) {
		this.atingida = atingida;
	}

	public Thread getTempo() {
		return tempo;
	}

	public void setTempo(Thread tempo) {
		this.tempo = tempo;
	}

	public boolean isContinuar() {
		return continuar;
	}

	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}

	private void lerInimigo() {
		try {
			imagem = ImageIO.read(new File("img\\inimigo.png"));
			altura = imagem.getHeight();
			largura = imagem.getWidth();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mover() {
		x -= 2;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.altura, this.largura);

	}

	@Override
	public void run() {

	}

	public void correrTempo() {
		tempo.start();
	}

	public void explodir() {
		if (atingida) {
			try {
				imagem = ImageIO.read(new File("img\\explosao.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			visivel=false;
		}
	}

}
