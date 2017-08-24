import javax.swing.JFrame;

public class JogarBola extends JFrame{
	
	
	private static final long serialVersionUID = 1L;



	public JogarBola() {
		add(new Tela());
		setLocationRelativeTo(null);
		setSize(800, 600);
		setVisible(true);
		setTitle("Jogar Bola");
	}

	
	public static void main(String[] args) {
		
		new JogarBola();
		
	}
	
}
