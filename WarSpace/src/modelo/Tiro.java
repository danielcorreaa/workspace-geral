package modelo;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tiro  extends BaseJogo{

	public Tiro(int x, int y) {
		super();
		lerTiro();
		visivel =true;
		this.x = x;
		this.y = y;
	}

	private void lerTiro() {
		try {
			imagem = ImageIO.read(new File("img\\tiro.png"));
			altura = imagem.getHeight();
			largura = imagem.getWidth();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void mover() {
		 x+=3;		
	}
	public void moverChefe() {
		 x-=3;		
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.altura, this.largura);
		
	}
}
