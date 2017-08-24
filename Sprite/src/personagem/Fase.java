package personagem;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;



@SuppressWarnings("serial")
public class Fase extends JPanel implements ActionListener{
	
	private Cenario cenario;	
	private Timer timer;
	public Fase() {
		super();		
		setDoubleBuffered(true);
		setFocusable(true);
		cenario = new Cenario();
		timer = new Timer(5, this);
		timer.start();
	}
	
	public Cenario getCenario() {
		return cenario;
	}

	public void setCenario(Cenario cenario) {
		this.cenario = cenario;
	}
	
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public void paint(Graphics g){
		Graphics2D gd2 = (Graphics2D) g;
		
		gd2.drawImage(cenario.getImagem(),cenario.getPosx(),cenario.getPosy() , null);
		
		gd2.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cenario.mover();
		repaint();
	}

	
	
	
	
}
