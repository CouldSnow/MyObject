package com.zy.observe.demo;

public class StateMain {

	
	public static void main(String[] args) {
		Saiya saiya = new Saiya();
		Athena athena = new Athena();
		saiya.addObserver(athena);
		
		for(int i=0;i<5;i++) {
			System.out.println(saiya.status());
			saiya.hit();
			
		}
	}
}
