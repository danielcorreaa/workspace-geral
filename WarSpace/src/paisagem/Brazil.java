package paisagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brazil implements Painel {
    
	private BufferedImage imagem;
	private int x , y;
	
	public Brazil() {
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
		y =-4617;
		this.y = y;
	}
	
	
	public BufferedImage getImagem() {
		return imagem;
	}



	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}



	@Override
	public void lerCenario() {		
		try {
			imagem = ImageIO.read(new File("img\\Brazil.png"));	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public BufferedImage imagem() {	
		lerCenario();
		return imagem;
	}



	@Override
	public int Movimentar() {		
		return y--;
	}

}
