import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Tela extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Bola bola;
	private Timer timer;
	
	

	public Tela() {
		super();
		addKeyListener(new Adaptador());
		setDoubleBuffered(true);
		setFocusable(true);
		bola = new Bola();
		timer = new Timer(5, this);
		timer.start();
	}
	
	

	public Bola getBola() {
		return bola;
	}



	public void setBola(Bola bola) {
		this.bola = bola;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public Timer getTimer() {
		return timer;
	}



	public void setTimer(Timer timer) {
		this.timer = timer;
	}



	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//cenario
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, 800, 600);
		
		//bola
		g2d.setColor(Color.blue);
		g2d.fillOval((int) bola.getX(),(int) bola.getY(),bola.getLargura(), bola.getAltura());
		
		g2d.dispose();
		
		
	}		
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 100; i < 0; i--) {
			bola.forca(i, 80);
			System.out.println(bola.getX());
			System.out.println(bola.getY());
		}
		
		repaint();
	}
	private class Adaptador extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {

		}
	}

	
}
