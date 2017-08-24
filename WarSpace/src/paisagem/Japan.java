package paisagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Japan implements Painel{
	private BufferedImage imagem;
	private int x , y;
	
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


	public Japan() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void lerCenario() {
		
		try {
			imagem = ImageIO.read(new File("img\\Japan.png"));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public BufferedImage imagem() {
		// TODO Auto-generated method stub
		return imagem;
	}


	@Override
	public int Movimentar() {
		// TODO Auto-generated method stub
		return y;
	}
	

}
