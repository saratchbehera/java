package com.sarat.oops;

public class TestPrivate {

	public static void main(String[] args) {
		TestPrivateMethods tpm = new TestPrivateMethods();
		tpm.FindL1();
	}
}

class TestPrivateMethods{
	public static void FindL1() {
		System.out.println("in FindL1");
		m1();
	}
	
	private static void m1() {
		System.out.println("in m1()");
		m2();
	}
	private static void m2() {
		System.out.println("in m2()");
	}
}
