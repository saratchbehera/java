package com.sarat.test;

class A1 {
	void doSomething(){
		System.out.println(" In A1");
	};
	
	void doA1(){
		System.out.println(" In A1");
	};
}

class A2 extends A1{
	 void doSomething(){
		System.out.println(" In A2");
	};
}


public class Test extends A2  { 

	public static void s1(String s){
		System.out.println("String");
	}
	
	public static void s1(Object o){
		System.out.println("Object");
	}
	
	String a = "Sarat";
	
	public static void main(String[] args) {
		
		Test test = new Test();
		test.doSomething();
		
		A2 a2 = new A2();
		a2.doSomething();
		
		A1 aa = new Test();
		aa.doSomething();
		
		System.out.println("Divide by zero  - "+ 1.0/0.0);
		
		s1(null);
		
		
	}
}
