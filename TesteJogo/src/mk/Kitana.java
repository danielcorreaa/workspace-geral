package mk;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Kitana {

	private int y , x;
	private BufferedImage img;
	
	public Kitana() {
		super();
		frame();
		
	    
	    y=200;
	    x=100;
	    		
	
	}
	
	public void frame(){
		try {
			img = ImageIO.read(new File("img\\nave.png"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	
	
}
