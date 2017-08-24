package modelo;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;



public class Nave extends BaseJogo {

	private List<Tiro> tiros = new ArrayList<>();
	protected int vidas;
	
	
	public Nave() {
		super();
		lerNave();
		x = 200;
		y = 300;
		vidas = 3;
	}
	
	

	public List<Tiro> getTiros() {
		return tiros;
	}



	public void setTiros(List<Tiro> tiros) {
		this.tiros = tiros;
	}



	@Override
	public void mover() {

	}

	public void lerNave() {
		try {
			imagem = ImageIO.read(new File("img\\nave.png"));
			altura = imagem.getHeight();
			largura = imagem.getWidth();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void keyPressed(KeyEvent e) {
		int cod = e.getKeyCode();
		if (KeyEvent.VK_UP == cod) {
			if (y > 0) {
				y -= 16;
			}

		}
		if (KeyEvent.VK_DOWN == cod) {
			if (y < 536) {
				y += 16;
			}

		}
		if (KeyEvent.VK_LEFT == cod) {
			if (x > -8) {
				x -= 16;
			}

		}
		if (KeyEvent.VK_RIGHT == cod) {
			if (x < 696) {
				x += 16;
			}

		}
		if (KeyEvent.VK_SPACE == cod) {
			atirar();
		}

	}

	
	public void keyReleased(KeyEvent e) {

	}
	

	public void atirar() {
		tiros.add(new Tiro(x + (largura / 2), y + (altura / 2)));
		
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.altura, this.largura);
		
	}
	
	
}
