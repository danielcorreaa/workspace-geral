package com.hotel.adm;

import java.util.Random;

public class Tempo {
	
	public static void main(String[] args) {
		
		System.out.println("inicio");
		
		Random randow = new Random();
//		int num = randow.nextInt(60);
//		
//		
//		int num2 = randow.nextInt(60);
//		
//		
//		int num3 = randow.nextInt(60);
//		
//		
//		int num4 = randow.nextInt(60);
//		
//		
//		int num5 = randow.nextInt(60);
//		
//		
//		int num6 = randow.nextInt(60);
//		
//		System.out.println(num);
//		System.out.println(num2);
//		System.out.println(num3);
//		System.out.println(num4);
//		System.out.println(num5);
//		System.out.println(num6);
		
		
		long teste = 0;
		for(int i = 60; i > 0; i--){
			
			if(i==60){				
				teste += i * (i-1);
			}else{				
				teste += teste * (i-1);
			}
			
		}
		
	 System.out.println(teste);
		
	}
	
}
