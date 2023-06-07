package com.openwebinars.stop;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Thread hilo=new Thread(()->{
			for(int i=0;i<=5;i++) {
				System.out.println("Iteración: "+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		hilo.start();
		
		Thread.sleep(2000);
		hilo.interrupt();
	}

}
