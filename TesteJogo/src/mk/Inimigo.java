package mk;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.RepaintManager;
import javax.swing.Timer;

public class Inimigo implements Runnable{
	
	private BufferedImage img;
	private int x, y;
	private boolean vivo;
	private Timer timer;
	private boolean continuar;
	public Inimigo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		vivo = true;
	   
		lerInimigo();
	
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
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public boolean isContinuar() {
		return continuar;
	}
	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public void mover(){
		
		x-=2;
		
	}
	
	public void lerInimigo(){
		
			try {
				img = ImageIO.read(new File("img\\inimigo.png"));	
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,img.getWidth(), img.getHeight());
	}
	
	
	
	
	
	public void explodir() {
		try {
			img = ImageIO.read(new File("img\\explosao.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
