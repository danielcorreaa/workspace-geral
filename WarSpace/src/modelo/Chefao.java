package modelo;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Chefao extends BaseJogo {

	private List<Tiro> tiros = new ArrayList();
	
	
	
	
	public Chefao() {
		super();
		// TODO Auto-generated constructor stub
		
	    lerNave();
		
		x=800;
		y=100;
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
	public void mover(boolean com) {
		   if(com){
			  if(x >400){ 
		        x-=2;
			  }else{
				  atirar();
			  }
		   }
		   //System.out.println("chefe"+x);		
	}
	public void lerNave() {
		try {
			imagem = ImageIO.read(new File("img\\spaceship.png"));
			altura = imagem.getHeight();
			largura = imagem.getWidth();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void atirar() {
		tiros.add(new Tiro(x + (largura / 2), y + (altura)));
		tiros.add(new Tiro(x + (largura / 2), y + (altura / 2)));
		tiros.add(new Tiro(x + (largura / 2), y + (altura / 3)));
		tiros.add(new Tiro(x + (largura / 2), y + (altura / 4)));
		
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.altura, this.largura);
		
		
	}

}
