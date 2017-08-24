package animacoes;

import java.awt.image.BufferedImage;

public interface Explosao {

	public void lerImg();
	public BufferedImage imagem();
	public int getY();
	public int getX();
	public void setY(int posY);
	public void setX(int posX);
	
}
