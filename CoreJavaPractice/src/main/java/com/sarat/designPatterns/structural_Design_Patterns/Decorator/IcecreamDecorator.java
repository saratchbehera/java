package com.sarat.designPatterns.structural_Design_Patterns.Decorator;

/**
 *  <p>This class is the <b>core</b> of the decorator design pattern. 
 *  It contains an attribute for the type of interface. 
 *  Instance is assigned dynamically at the creation of decorator using its constructor. 
 *  Once assigned that instance method will be invoked.</p>
 *  
 * @author Sarat Behera
 *
 */
public abstract class IcecreamDecorator implements Icecream{

	protected Icecream specialIcecream;
	
	public IcecreamDecorator(Icecream specialIcecream) {
		this.specialIcecream = specialIcecream;
	}
	
	public String makeIcecream() {
		return specialIcecream.makeIcecream();		
	}
}
