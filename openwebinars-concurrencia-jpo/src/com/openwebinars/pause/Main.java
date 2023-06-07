package com.openwebinars.pause;

public class Main {
	
	public static void main(String[] args) {
		Thread hilo=new Thread(()->{
			for(int i=0;i<=20;i++) {
				System.out.println("Iteración: "+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		hilo.start();
	}

}
