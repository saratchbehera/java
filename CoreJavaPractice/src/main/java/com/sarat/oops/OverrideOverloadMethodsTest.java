package com.sarat.oops;

class Overload{	
	public void m1() {
		System.out.println("In Overload m1()");
	}	
	public void m1(String m) {
		System.out.println("In Overload m1(String m)" + m);
	}
}
class Child extends Overload{
	public void m1() {
		System.out.println("In Child Overload m1()");
	}
	
	public void m1(String m) {
		System.out.println("In Child Overload m1(String m)" + m);
	}
}
public class OverrideOverloadMethodsTest {

	public static void main(String[] args) {
		Overload child = new Child();
		child.m1();
		child.m1("Sarat");
	}
}
