package personagem;

import javax.swing.JFrame;

public class Jogar extends JFrame{

	private static final long serialVersionUID = 1L;

	public Jogar() {
		super();
		add(new Fase());
		setSize(800, 600);
		setLocationRelativeTo(this);
		setVisible(true);
		setTitle("Sprite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new Jogar();
	}

}
