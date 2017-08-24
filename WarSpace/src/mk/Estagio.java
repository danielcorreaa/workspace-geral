package mk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import modelo.Cenario;

public class Estagio extends JPanel implements ActionListener {
	 private Cenario cenario;
	    private Timer timer;
	    private Kitana kitana;
	    private EfeitosSonoros som;

	    public Estagio() {
	        setFocusable(true);
	        setDoubleBuffered(true);
	        addKeyListener(new TecladoAdapter());
	        escolherCenario();
	        kitana = new Kitana();
	        kitana.lerImagem();
	        timer = new Timer(5, this);
	        timer.start();
	        som = new EfeitosSonoros();
	        som.TocaAudio("lib//som//49.wav");
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

	    public Kitana getKitana() {
	        return kitana;
	    }

	    public void setKitana(Kitana kitana) {
	        this.kitana = kitana;
	    }

	    public void paint(Graphics g) {
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(Color.white);
	        g2d.fillRect(0, 0, 800, 600);
	        //g2d.drawImage(cenario.desenharCenario(), null, this);
	        g2d.drawImage(kitana.getBufferImg(), kitana.getX(), 110, this);

	        g2d.dispose();
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //kitana.andar();
	        repaint();
	    }

	    private void escolherCenario() {
	        //enario = new Deadpool();
	    }

	    private class TecladoAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {
	            kitana.keyReleased(e);
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	            kitana.keyPressed(e);

	        }
	    }

	
}
