
public class Teste {
	
	
	public static void main(String[] args) {
		forca(100, 80);
		
	}
	static double x;
	static double y;
	public static void forca(int velocidade, double angulo){
		double radians = (angulo /180 )* Math.PI;
		x = velocidade * Math.cos(radians);
		y = velocidade * Math.sin(radians);
		
	}
}
