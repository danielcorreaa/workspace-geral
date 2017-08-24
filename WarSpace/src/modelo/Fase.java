package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import animacoes.Explosao;
import animacoes.ExplosaoInimigo;
import paisagem.Brazil;
import paisagem.Painel;




@SuppressWarnings("serial")
public class Fase extends JPanel implements ActionListener {

	public BufferedImage fundo;
	private int x;
	private Nave nave;
    private Cenario cenario;
	//private Painel painel;
	private Timer timer;
	private List<Inimigo> inimigos = new ArrayList<>();
	
	private boolean iniciar;
	private boolean gameover;
	private int pontos;
	private Chefao chefao;
	
	

	public Fase() {
		super();
		addKeyListener(new Adaptador());
		setDoubleBuffered(true);
		setFocusable(true);
		nave = new Nave();
		gameover = false;
		//painel = new Brazil();
		
		cenario = new Cenario();
		chefao = new Chefao();
		
		
		pontos = 0;
		adicionarInimigos();
		iniciar = true;
		

		timer = new Timer(5, this);
		timer.start();
	}

	public BufferedImage getFundo() {
		return fundo;
	}

	public void setFundo(BufferedImage fundo) {
		this.fundo = fundo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public List<Inimigo> getInimigos() {
		return inimigos;
	}

	public void setInimigos(List<Inimigo> inimigos) {
		this.inimigos = inimigos;
	}

	public boolean isIniciar() {
		return iniciar;
	}

	public void setIniciar(boolean iniciar) {
		this.iniciar = iniciar;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!gameover){
			if (!iniciar) {
			
				cenario.mover();
				//painel.Movimentar();
				if(!cenario.isEmMovimento()){
					chefao.mover(true);
				}else{
					chefao.mover(false);
				}
				
				chefao.mover();
				
				for (int i = 0; i < chefao.getTiros().size(); i++) {
					Tiro tiro = chefao.getTiros().get(i);
					if (tiro.isVisivel()) {
						tiro.moverChefe();
					}else{
						nave.getTiros().remove(i);
					}
		
				}
				
				for (int i = 0; i < nave.getTiros().size(); i++) {
					Tiro tiro = nave.getTiros().get(i);
					if (tiro.isVisivel()) {
						tiro.mover();
					}else{
						nave.getTiros().remove(i);
					}
		
				}
				for (int i = 0; i < inimigos.size(); i++) {
					Inimigo ini = inimigos.get(i);
					
					if (ini.isVisivel()) {
						ini.mover();
					} else {
						inimigos.remove(i);
					}
					
		
				}
			
			colisao();
			}
		}
		repaint();
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(!gameover){
			if (iniciar) {
				g2d.setColor(Color.black);
				g2d.fillRect(0, 0, 800, 600);
				Font font = new Font("Bitstream Vera Sans", Font.PLAIN, 40);
				g2d.setFont(font);
				g2d.setColor(Color.YELLOW);
				g2d.drawString("Pressione Enter para começar", 140, 270);
				
			}else{
				//cenario
				g2d.setColor(Color.black);
				g2d.fillRect(0, 0, 800, 600);
				g2d.drawImage(cenario.getImagem(), cenario.getX(),cenario.getY(),  this);
				
				//nave
				
				g2d.drawImage(nave.getImagem(), nave.getX(), nave.getY(), null);
				
				g2d.drawImage(chefao.getImagem(), chefao.getX(), chefao.getY(), null);
				
				//tiro
				for (int i = 0; i < nave.getTiros().size(); i++) {
					Tiro tiro = nave.getTiros().get(i);
					g2d.drawImage(tiro.getImagem() , tiro.getX(), tiro.getY(), null);
	
				}
				for (int i = 0; i < inimigos.size(); i++) {
					Inimigo ini = inimigos.get(i);
	
					g2d.drawImage(ini.getImagem(), ini.getX(), ini.getY(), null);
	
				}
				//explosao
				
				
				//pontos
				Font font = new Font("ARIAL", Font.PLAIN, 40);
				g2d.setFont(font);
				g2d.setColor(Color.YELLOW);
				g2d.drawString(String.valueOf(pontos), 20, 50);
				
	            //tiro chefe
				for (int i = 0; i < chefao.getTiros().size(); i++) {
					Tiro tiro = chefao.getTiros().get(i);
					g2d.drawImage(tiro.getImagem() , tiro.getX(), tiro.getY(), null);
	
				}
			}
		}else{
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, 800, 600);
			Font font = new Font("Bitstream Vera Sans", Font.PLAIN, 40);
			g2d.setFont(font);
			g2d.setColor(Color.YELLOW);
			g2d.drawString("Game Over Pressione BackSpace", 100, 270);
		}
		
		g2d.dispose();
	}

	private class Adaptador extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			nave.keyPressed(e);
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				iniciar = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				
			}
			
			
		}

		public void keyReleased(KeyEvent e) {

		}
	}
	
	public void adicionarInimigos() {

		inimigos.add(new Inimigo(700, 200));
		inimigos.add(new Inimigo(800, 300));
		inimigos.add(new Inimigo(1200, 100));
		inimigos.add(new Inimigo(1000, 400));
		inimigos.add(new Inimigo(900, 100));
		inimigos.add(new Inimigo(1500, 200));
		inimigos.add(new Inimigo(1300, 500));
		inimigos.add(new Inimigo(1700, 150));
		inimigos.add(new Inimigo(1400, 200));
		inimigos.add(new Inimigo(1800, 300));

		inimigos.add(new Inimigo(1700, 400));
		inimigos.add(new Inimigo(1800, 100));
		inimigos.add(new Inimigo(1200, 500));
		inimigos.add(new Inimigo(1900, 300));
		inimigos.add(new Inimigo(2000, 100));
		inimigos.add(new Inimigo(2100, 200));
		inimigos.add(new Inimigo(2200, 500));
		inimigos.add(new Inimigo(2500, 150));
		inimigos.add(new Inimigo(3000, 200));
		inimigos.add(new Inimigo(2700, 300));

		inimigos.add(new Inimigo(2700, 400));
		inimigos.add(new Inimigo(2800, 100));
		inimigos.add(new Inimigo(2200, 500));
		inimigos.add(new Inimigo(2900, 300));
		inimigos.add(new Inimigo(3000, 100));
		inimigos.add(new Inimigo(3100, 200));
		inimigos.add(new Inimigo(3200, 500));
		inimigos.add(new Inimigo(3500, 150));
		inimigos.add(new Inimigo(4000, 200));
		inimigos.add(new Inimigo(4700, 300));

		inimigos.add(new Inimigo(3700, 400));
		inimigos.add(new Inimigo(4800, 100));
		inimigos.add(new Inimigo(4200, 500));
		inimigos.add(new Inimigo(3900, 300));
		inimigos.add(new Inimigo(4000, 100));
		inimigos.add(new Inimigo(4100, 200));
		inimigos.add(new Inimigo(4200, 500));
		inimigos.add(new Inimigo(4500, 150));
		inimigos.add(new Inimigo(5000, 200));
		inimigos.add(new Inimigo(5700, 300));
		
		inimigos.add(new Inimigo(5700, 400));
		inimigos.add(new Inimigo(5800, 100));
		inimigos.add(new Inimigo(5200, 500));
		inimigos.add(new Inimigo(5900, 300));
		inimigos.add(new Inimigo(5000, 100));
		inimigos.add(new Inimigo(5100, 200));
		inimigos.add(new Inimigo(6200, 500));
		inimigos.add(new Inimigo(6500, 150));
		inimigos.add(new Inimigo(6000, 200));
		inimigos.add(new Inimigo(6700, 300));

		inimigos.add(new Inimigo(6700, 400));
		inimigos.add(new Inimigo(6800, 100));
		inimigos.add(new Inimigo(6200, 500));
		inimigos.add(new Inimigo(6900, 300));
		inimigos.add(new Inimigo(7000, 100));
		inimigos.add(new Inimigo(7100, 200));
		inimigos.add(new Inimigo(7200, 500));
		inimigos.add(new Inimigo(7500, 150));
		inimigos.add(new Inimigo(7000, 200));
		inimigos.add(new Inimigo(7700, 300));

		inimigos.add(new Inimigo(7700, 400));
		inimigos.add(new Inimigo(7800, 100));
		inimigos.add(new Inimigo(7200, 500));
		inimigos.add(new Inimigo(7900, 300));
		inimigos.add(new Inimigo(8000, 100));
		inimigos.add(new Inimigo(8100, 200));
		inimigos.add(new Inimigo(8200, 500));
		inimigos.add(new Inimigo(8500, 150));
		inimigos.add(new Inimigo(9000, 200));
		inimigos.add(new Inimigo(9700, 300));
	}

	public void colisao() {
		Rectangle rNave = nave.getBounds();
		Rectangle rInimigo;
		Rectangle rTiro;
		
		for (int j = 0; j < nave.getTiros().size(); j++) {
			Tiro tiro = nave.getTiros().get(j);
			rTiro = tiro.getBounds();
			for (int i = 0; i < inimigos.size(); i++) {
				Inimigo ini = inimigos.get(i);
				rInimigo = ini.getBounds();
				if (rTiro.intersects(rInimigo)) {
					ini.setAtingida(true);					
				    ini.explodir();
					
					pontos+=10;
					
				}
			}
		}

		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo ini = inimigos.get(i);
			rInimigo = ini.getBounds();
			if (ini.isVisivel()) {
				if (rInimigo.intersects(rNave)) {					
					gameover=true;
					inicializar();
				}
			}

		}

	}
	BufferedImage img = null;
	public void vidas(){
		
		if(nave.vidas ==3){
			try {
				img = ImageIO.read(new File("img\\3vidas.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(nave.vidas ==2){
			try {
				img = ImageIO.read(new File("img\\2vidas.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(nave.vidas == 1){
			try {
				img = ImageIO.read(new File("img\\1vida.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public void inicializar(){
		addKeyListener(new Adaptador());
		setDoubleBuffered(true);
		setFocusable(true);
		nave = new Nave();
		gameover = false;
		
		
		
		x = 0;
		pontos = 0;
		adicionarInimigos();
		iniciar = true;
		

		timer = new Timer(5, this);
		timer.start();
	}

}
