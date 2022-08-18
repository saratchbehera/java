package com.sarat.designPatterns.creational_Design_Patterns;


/**
 * <p>****	Prototype Design Pattern	****<p>
 * 
 * Creating an object is time consuming and a costly affair and if you already have a most similar object instance in hand,
 * then you go for prototype pattern. 
 * Instead of going through a time consuming process to create a complex object, just copy the existing similar object and modify it according to your needs.
 * 
 * <p>****	Confusion with Builder Design Pattern	****<p>
 * Prototype pattern may look similar to builder design pattern. There is a huge difference to it. 
 * �The same construction process can create different representations� is the key in builder pattern. But not in the case of prototype pattern.
 * 
 * <p>For Prototype Design Pattern Cloning is used clone, whether you need a shallow copy or deep copy. Decide based on your business needs. 
 * If you need a deep copy, you can use serialization as a hack to get the deep copy done. 
 * Using clone to copy is entirely a design decision while implementing the prototype design pattern. <p>
 * 
 * <p>****	Shallow Copy	****<p>
 * 
 * Generally clone method of an object, creates a new instance of the same class 
 * and copies all the fields to the new instance and returns it. This is nothing but shallow copy. 
 * Object class provides a clone method and provides support for the shallow copy. 
 * It returns �Object� as type and you need to explicitly cast back to your original object.
 * The class which you want to be cloned should implement clone method and overwrite it.
 * 
 * <p>****	Deep Copy	****<p>
 * 
 * When you need a deep copy then you need to implement it yourself. 
 * When the copied object contains some other object its references are copied recursively in deep copy.
 * When you implement deep copy be careful as you might fall for cyclic dependencies. 
 * If you don�t want to implement deep copy yourselves then you can go for <b>serialization</b>. 
 * It does implements deep copy implicitly and gracefully handling cyclic dependencies.
 * 
 * <p>Note : Clone is not a mandatory choice for prototype pattern.<p>
 * 
 * @author Sarat Behera
 *
 */
class OriginalClass implements Cloneable {
	
	private int Variable_One;    
	private String Variable_Two;   
	private String Variable_Three;    

	public OriginalClass() {
		
		this.Variable_One = 4;
		this.Variable_Two = "Some Val";
		this.Variable_Three = "Some Value";				
	}

	public OriginalClass clone() {
		return new OriginalClass();
	}

	public void allotValues() {
		
		this.Variable_One = 6;
		this.Variable_Two = "Some Adv Val";
		this.Variable_Three = "Some Advanced Value";
	}

	// Getters for variable one two and three
	public int getVariable_One() {
		return Variable_One;
	}
	
	public String getVariable_Two() {
		return Variable_Two;
	}
	
	public String getVariable_Three() {
		return Variable_Three;
	}
}

public class PrototypeDesignPattern {

	public OriginalClass allotNewValues(OriginalClass originalClass) {
		
		originalClass.allotValues();
		return originalClass;
	}

	public static void main(String args[]) {
		
		OriginalClass originalClass = new OriginalClass();		
		OriginalClass clone = originalClass.clone();
		PrototypeDesignPattern prototype = new PrototypeDesignPattern();
		OriginalClass newOriginalClass = prototype.allotNewValues(clone);
		
		System.out.println("Prototype Design Pattern: "	+ newOriginalClass.getVariable_Three());
	}

}
