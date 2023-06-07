package com.openwebinars.async;

public class Main {
	
	public static void main(String[] args) {
		Thread thread1=new Thread(()->System.out.println("Hola 1"));
		Thread thread2=new Thread(()->System.out.println("Hola 2"));
		Thread thread3=new Thread(()->System.out.println("Hola 3"));
		
		//Asincronía
//		System.out.println("Inicio");
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		System.out.println("Fin");
		
		//Sincronía: El hilo principal queda bloqueado hasta que el resto termina
		System.out.println("Inicio");
		thread1.run();
		thread2.run();
		thread3.run();
		System.out.println("Fin");
	}

}
