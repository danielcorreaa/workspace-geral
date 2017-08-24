package leitura;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LeituraArquivoImagem {
	
	public static BufferedImage lerArquivo(String arq){
		BufferedImage imagem = null;
		BufferedImage img = null;
		try {
			imagem = ImageIO.read(new File(arq));
		    img = imagem.getSubimage(0, 0, 3392, 227);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return img;
	}
	
}
