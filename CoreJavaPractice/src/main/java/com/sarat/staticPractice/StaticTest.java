package com.sarat.staticPractice;

public class StaticTest {
	
	static {
		System.out.println("in static block");
	}

	public static void main(String[] args) {
		StaticTest s = new StaticTest();
		s.m1();
		System.out.println("in main");
		s.m1();
	}
	
	public static void m1(){
		System.out.println("in m1");
	}

}
