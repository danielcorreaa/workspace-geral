package mk;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Nave{

	private int posx, posy;
	private BufferedImage bf;
	private int x, y;
	private int altura, largura;
	private List<Tiro> tiros = new ArrayList<>();
	
	private boolean continuar;

	public Nave() {
		super();
		lerNave();

		posx = 200;
		posy = 200;
		System.out.println(getBounds());
		
		continuar = true;
	}

	public BufferedImage getBf() {
		return bf;
	}

	public void setBf(BufferedImage bf) {
		this.bf = bf;
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

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

	public void setTiros(List<Tiro> tiros) {
		this.tiros = tiros;
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

	public void cair() {
		posy--;
		if (posy > 300) {
			posy = 200;
		}

	}

	public void lerNave() {
		try {
			bf = ImageIO.read(new File("img\\nave.png"));
			altura = bf.getHeight();
			largura = bf.getWidth();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void keyPressed(KeyEvent e) {
		int cod = e.getKeyCode();
		if (KeyEvent.VK_UP == cod) {
			if (posy > 0) {
				posy -= 8;
			}

		}
		if (KeyEvent.VK_DOWN == cod) {
			if (posy < 536) {
				posy += 8;
			}

		}
		if (KeyEvent.VK_LEFT == cod) {
			if (posx > -8) {
				posx -= 8;
			}

		}
		if (KeyEvent.VK_RIGHT == cod) {
			if (posx < 696) {
				posx += 8;
			}
 
		}
		if (KeyEvent.VK_SPACE == cod) {
			atirar();
		}

	}

	public void keyReleased(KeyEvent e) {

	}

	public void mover() {
		posy += 1;
		if (posy == 500) {
			posy = 0;
		}
	}

	public void atirar() {
		tiros.add(new Tiro(posx + (largura / 2), posy + (altura / 2)));
	}

	public Rectangle getBounds() {
		return new Rectangle(posx, posy, bf.getWidth(), bf.getHeight());
	}

	

}
