package modelo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cenario extends BaseJogo {
	
	private boolean emMovimento;
	private Chefao chefao;
	
	public Cenario() {
		super();
		x=0;
		y=0;
		lerImagem();
		emMovimento =true;
	}
	
	

	public boolean isEmMovimento() {
		return emMovimento;
	}



	public void setEmMovimento(boolean emMovimento) {
		this.emMovimento = emMovimento;
	}



	private void lerImagem() {
		try {
			imagem = ImageIO.read(new File("img\\fundo.png"));	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void mover() {
		if(x>-5000){
		   x -= 1;
		   ///System.out.println(emMovimento);
		}else{
		   emMovimento =false;
		  // System.out.println(emMovimento);
		}
		
	}
	
	
	



		

}
