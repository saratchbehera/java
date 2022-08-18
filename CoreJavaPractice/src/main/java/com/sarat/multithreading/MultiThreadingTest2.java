package com.sarat.multithreading;

public class MultiThreadingTest2 implements Runnable{

	public static void main(String[] args) {
		MultiThreadingTest2 m2 = new MultiThreadingTest2();
		Thread t = new Thread(m2);
		t.start();
	}
	@Override
	public void run() {
		
		
	}

}
