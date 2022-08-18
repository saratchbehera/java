package com.sarat.abstractClass;

/**
 * Final Method of a abstract class can be accessed using inheritance.
 * @author Sarat
 *
 */
abstract class Ab{
	public final void m1(){
		System.out.println("in class A method m1()");
	}
}
public class FinalMethodAccess extends Ab{

	public static void main(String[] args) {
		FinalMethodAccess f = new FinalMethodAccess();
		f.m1();
	}

}
