package com.sarat.abstractClass;

abstract class abstractClass{
	public abstractClass() {
		System.out.println("In TestAbstractClass Constructor");
	}
}

class RegularClass{
	public RegularClass() {
		System.out.println("In RegularClass Constructor");
	}
}

public class ConstructorTestInAbstractClass {

	public static void main(String[] args) {
		callAbstract();
	}
	
	public static void callAbstract() {
		Class<?> t;
		try {
			t = Class.forName("practice.sarat.abstractClass.RegularClass");
			t.newInstance();
			
			
			t = Class.forName("practice.sarat.abstractClass.abstractClass");
			t.newInstance();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
