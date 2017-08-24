package com.servlet.adm;

public class StringBuff {
	
	public static void main(String[] args) {
		StringBuilder buider = new StringBuilder("daniel");
		//buider.insert(3, "correa").reverse().append(123).delete(6, 9);
		//buider.reverse();
		buider.delete(1, 9);
		System.out.println(buider);
	}
		
}
