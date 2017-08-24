package animacoes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExplosaoInimigo implements Explosao {

	private BufferedImage imagem;
	private int x, y;

	@Override
	public void lerImg() {
		try {
			imagem = ImageIO.read(new File("img\\explosao.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BufferedImage imagem() {
		return imagem;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setY(int posY) {
		y = posY;

	}

	@Override
	public void setX(int posX) {
		x = posX;

	}

}
