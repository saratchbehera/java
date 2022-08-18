package com.sarat.polymorphism;

/**
 * 
 * Polymorphism in java is a concept by which we can perform a single action by
 * different ways. So polymorphism means many forms.
 * 
 * There are two types of polymorphism in java. 1. Compile time Polymorphism 2.
 * Run time Polymorphism.
 * 
 * We can perform polymorphism in java by method overloading and method
 * overriding.
 * 
 * <p>***** Compile time Polymorphism ******<p>
 * 
 * If you overload static method in java, it is the example of compile time
 * polymorphism.
 * 
 * <p>***** Run time Polymorphism / Dynamic Method Dispatch ******<p>
 * 
 * Runtime polymorphism is a process in which a call to an overridden method is
 * resolved at runtime rather than compile-time. In this process, an overridden
 * method is called through the reference variable of a superclass. The
 * determination of the method to be called is based on the object being
 * referred to by the reference variable.
 * 
 * <p>******	Upcasting	********<p>
 * When reference variable of Parent class refers to the
 * object of Child class, it is known as upcasting.
 * 
 * @author 
 * Sarat Behera
 * 
 */
public class RunTimePolymorphismDemo {

	public static void main(String[] args) {
		// upcasting
		Polymorphism polymorphism = new RuntimePolymorphism();
		polymorphism.run();
	}
}

class Polymorphism {
	void run() {
		System.out.println("In Class Polymorphism - run()");
	}
}

class RuntimePolymorphism extends Polymorphism {
	void run() {
		System.out.println("In Class RuntimePolymorphism - run()");
	}
}