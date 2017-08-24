package paisagem;

import java.awt.image.BufferedImage;

public interface Painel {
	
	public void lerCenario();	
	public BufferedImage imagem();
	public int Movimentar();
	public int getY();
	
}
