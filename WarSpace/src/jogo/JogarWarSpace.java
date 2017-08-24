package jogo;

import javax.swing.JFrame;


import modelo.Fase;

@SuppressWarnings("serial")
public class JogarWarSpace extends JFrame{
    
	public JogarWarSpace() {
		super();
		add(new Fase());
		setTitle("War Space");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
   
	public static void main(String args[]){		
		new JogarWarSpace();
	}
	
}
