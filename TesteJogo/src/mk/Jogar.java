package mk;


import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Jogar extends JFrame{
	
	public Jogar() {
		super();
		add(new Tela());
		setTitle("Teste Jogo");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}

	public static void main(String[] args) {		
		new Jogar();
		
	}

}
