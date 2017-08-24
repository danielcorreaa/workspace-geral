import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tempo extends JPanel implements Runnable {

	private String nome;
	private Thread thread;
	private int cont;
	private boolean continuar;

	public Tempo(int contador) {
		super();
		thread = new Thread(this);
		cont = contador;
		continuar = true;
		correrTempo();
		JLabel label = new JLabel("teste");
		label.setBounds(100, 100, 120, 30);
		add(label);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	@Override
	public void run() {
		thread.start();
	}

	public void correrTempo() {

		while (continuar) {
			try {
				Thread.sleep(1000);
				cont--;
				JLabel label = new JLabel(String.valueOf(cont));
				label.setBounds(100, 100, 120, 30);
				add(label);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (cont == 0) {
				continuar = false;
			}

		}

	}

}
