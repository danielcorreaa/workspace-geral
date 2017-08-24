

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Janela extends JFrame implements Runnable {
	private Thread thread;
	private int cont;
	private boolean continuar;
	
	public void correrTempo() {

		while (continuar) {
			try {
				Thread.sleep(1000);
				cont--;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (cont == 0) {
				continuar = false;
			}

		}

	}

	public Janela()  {
		super();
		//add(new Painel());
		setSize(600, 400);
		setTitle("Thread");
		setLocationRelativeTo(this);
		setVisible(true);
		JLabel label = new JLabel(String.valueOf(cont));
		label.setBounds(100, 100, 120, 30);
		add(label);
	}
	
	public static void main(String[] args) {
		new Janela();
	}

	@Override
	public void run() {
		thread.start();
	}
	
	

}
