package com.sarat.abstractClass;

interface A{
	void a();
	void b();
	void c();
	void d();
}

abstract class B implements A{
	public void c(){
		System.out.println("In Abstract Class B - Method c() ");
	}
}

class C extends B{

	@Override
	public void a() {
		System.out.println("In Class C - Method a() ");		
	}

	@Override
	public void b() {
		System.out.println("In Class C - Method b() ");		
	}

	@Override
	public void d() {
		System.out.println("In Class C - Method d() ");
	}
	
}
public class BenefitOfAbstractClass {
	
	public static void main(String[] args) {
		A a = new C();
		a.a();
		a.b();
		a.c();
		a.d();

	}

}
