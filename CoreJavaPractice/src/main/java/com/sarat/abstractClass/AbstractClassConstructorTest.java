package com.sarat.abstractClass;

/**
 * We can call abstract class constructor even though abstract class can not create an object.
 * @author saratchandrabehera
 *
 */
abstract class ABC{
	
	public ABC() {
		System.out.println("in ABC");
	}
	
	public void A() {
		System.out.println("A");
	}

}

class BCD extends ABC{
	
	public BCD() {
		System.out.println("in BCD");
	}
	
	public void A() {
		System.out.println(" in BCD - A");
	}

	public void C() {
		System.out.println("C");
	}
}

public class AbstractClassConstructorTest {

	public static void main(String[] args) {
		
		//Reference type class initialization can directly access parent class methods.
		ABC bcd = new BCD();
		//If we want to access the child class method,then we have to downcast.
		((BCD) bcd).C();
		
	}
	

}
