package mk;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tiro {

	private BufferedImage img;
	private int x, y;
	private boolean visivel;
	
	public Tiro() {		
		super();
	}
	
	public Tiro(int x, int y) {
		super();
		lerTiro();
		visivel =true;
		this.x = x;
		this.y = y;
	}

	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
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
	
	
	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public void lerTiro(){
		try {
			img = ImageIO.read(new File("img\\tiro.png"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void atirar(){
		x+=3;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,img.getWidth(), img.getHeight());
	}

}
