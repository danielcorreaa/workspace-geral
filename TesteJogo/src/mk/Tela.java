package mk;

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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tela extends JPanel implements ActionListener {

	public BufferedImage fundo;
	private int x;
	private Nave nave;
	private Timer timer;
	private List<Inimigo> inimigos = new ArrayList<>();
	private int contMortos = 0;
	private boolean inicio;
	private boolean gameover;
	private int pontos;
	private Thread tempo;

	public Tela() {
		super();
		addKeyListener(new Adaptador());
		setDoubleBuffered(true);
		setFocusable(true);
		lerFundo();
		nave = new Nave();
		x = 0;
		pontos = 10;
		adicionarInimigos();
		inicio = true;
		gameover = false;

		timer = new Timer(5, this);
		timer.start();

	}

	public void lerFundo() {
		try {
			fundo = ImageIO.read(new File("img\\Fundo.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public BufferedImage getFundo() {
		return fundo;
	}

	public void setFundo(BufferedImage fundo) {
		this.fundo = fundo;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public List<Inimigo> getInimigos() {
		return inimigos;
	}

	public void setInimigos(List<Inimigo> inimigos) {
		this.inimigos = inimigos;
	}

	public int getContMortos() {
		return contMortos;
	}

	public void setContMortos(int contMortos) {
		this.contMortos = contMortos;
	}

	public boolean isInicio() {
		return inicio;
	}

	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}

	public boolean isGameover() {
		return gameover;
	}

	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		if (inicio) {
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, 800, 600);
			Font font = new Font("ARIAL", Font.PLAIN, 40);
			g2d.setFont(font);
			g2d.setColor(Color.YELLOW);
			g2d.drawString("Pressione Enter para começar", 140, 270);
			g2d.dispose();
		} else {
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, 800, 600);

			g2d.drawImage(fundo, x, 100, null);

			Font font = new Font("ARIAL", Font.PLAIN, 40);
			g2d.setFont(font);
			g2d.setColor(Color.YELLOW);
			g2d.drawString(String.valueOf(pontos), 20, 50);

			g2d.drawImage(nave.getBf(), nave.getPosx(), nave.getPosy(), null);

			for (int i = 0; i < nave.getTiros().size(); i++) {
				Tiro tiro = nave.getTiros().get(i);

				g2d.drawImage(tiro.getImg(), tiro.getX(), tiro.getY(), null);

			}

			for (int i = 0; i < inimigos.size(); i++) {
				Inimigo ini = inimigos.get(i);

				g2d.drawImage(ini.getImg(), ini.getX(), ini.getY(), null);

			}
			g2d.dispose();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// nave.mover();

		if (!inicio) {
			for (int i = 0; i < nave.getTiros().size(); i++) {
				Tiro tiro = nave.getTiros().get(i);
				if (tiro.isVisivel()) {
					tiro.atirar();
				}else{
					nave.getTiros().remove(i);
				}

			}
			for (int i = 0; i < inimigos.size(); i++) {
				Inimigo ini = inimigos.get(i);
				if (ini.isVivo()) {
					ini.mover();
				} else {
					inimigos.remove(i);
				}

			}
			colisao();
			// moverCenario();

			repaint();
		}

	}

	private class Adaptador extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			nave.keyPressed(e);
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				inicio = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				inicialiar();
			}
		}

		public void keyReleased(KeyEvent e) {

		}
	}

	public void moverCenario() {
		x -= 1;
		if (x == -4400) {
			x = 800;
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
					
					ini.explodir();
					
					ini.setVivo(false);
					tiro.setVisivel(false);
					// tiro.setVisivel(false);
					 pontos+=10;
					
				}
			}
		}

		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo ini = inimigos.get(i);
			if (ini.isVivo()) {
				if (nave.getBounds().intersects(ini.getBounds())) {
					gameover = true;
				}
			}

		}

	}

	public void inicialiar() {
		addKeyListener(new Adaptador());
		setFocusable(true);
		lerFundo();
		nave = new Nave();
		x = 100;

		adicionarInimigos();
		inicio = true;
		gameover = false;
		timer = new Timer(5, this);
		timer.start();

	}

}
