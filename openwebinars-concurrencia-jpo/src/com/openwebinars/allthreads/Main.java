package com.openwebinars.allthreads;

public class Main {
	
	public static void main(String[] args) {
		for(Thread thread:Thread.getAllStackTraces().keySet()) {
			System.out.println(thread.getId());
			System.out.println(thread.getName());
			System.out.println(thread.getState());
			System.out.println(thread.isAlive());
			System.out.println("------------------");
		}
	}

}
