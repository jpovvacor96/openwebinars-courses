package com.openwebinars.wait;

public class Main {
	
	public static void main(String[] args) {
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
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("My name is "+Thread.currentThread().getName()
				+", state: "+Thread.currentThread().getState());
	}

}
