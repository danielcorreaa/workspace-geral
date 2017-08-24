package mk;

import javax.swing.JFrame;

import modelo.Fase;

public class MortalKombat extends JFrame{
	
	

	public MortalKombat() {
		super();
		add(new Estagio());
		setTitle("MK");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
	    new MortalKombat();
	}

}
