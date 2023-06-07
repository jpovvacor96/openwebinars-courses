package com.openwebinars.polling;

import java.util.List;
import java.util.ArrayList;

public class Main {
	
	static List<String> messages=List.of("m1", "m2", "m3", "m4");
	
	static long patience=5000;
	
	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().setName("thread1");
		long startTime=System.currentTimeMillis();
		Thread thread2=new Thread(()->{
			Thread.currentThread().setName("Thread2");
			print("Iniciando trabajo");
			for(String msg:messages) {
				try {
					Thread.sleep(4000);
					print(msg);
				} catch (InterruptedException e) {
					print("Hilo interrumpido");
				}
			}
			print("Hilo parado");
		});
		thread2.start();
		while(thread2.isAlive()) {
			print("Continúo esperando");
			thread2.join(1000);
			long endTime=System.currentTimeMillis();
			long elapsed=endTime-startTime;
			if(elapsed>patience && thread2.isAlive()) {
				print("No espero más!!");
				thread2.interrupt();
				thread2.join();
			}
		}
		print("Fin");
	}
	
	static void print(String message) {
		String threadName=Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

}
