		
	
public class Main {
	
	public static void main(String[] args) {
//		Tempo tempo = new Tempo("Tempo 1");		
//		Thread tr1 = new Thread(tempo);
//		//System.out.println(tempo.getNome());
//		tr1.start();
//		
//		Tempo tempo2 = new Tempo("Tempo 2");		
//		Thread tr2 = new Thread(tempo2);
//		//System.out.println(tempo2.getNome());
//		tr2.start();
		
		
		Tempo tempo = new Tempo(10);
		tempo.correrTempo();
		System.out.println(tempo.getCont());
		
		
	}
}
