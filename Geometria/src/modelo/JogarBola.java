package modelo;
import javax.swing.JFrame;

public class JogarBola extends JFrame{
	
	
	private static final long serialVersionUID = 1L;



	public JogarBola() {
		add(new Tela());
		
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jogar Bola");
	}

	
	public static void main(String[] args) {
		
		new JogarBola();
		
	}
	
}
