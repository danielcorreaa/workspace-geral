package modelo;

public class Bola {
	
	private double x , y;
	private int altura, largura;

	public Bola() {
		super();
		// TODO Auto-generated constructor stub
		x = 300;
		y = 250;
		altura  = 50;
		largura = 50;
	}
	

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
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


	public void forca(int velocidade, double angulo){
		double radians = (angulo / 18 ) * Math.PI;
		this.x = velocidade * Math.cos(radians);
		this.y = velocidade * Math.sin(radians);
	
	}
	
}
