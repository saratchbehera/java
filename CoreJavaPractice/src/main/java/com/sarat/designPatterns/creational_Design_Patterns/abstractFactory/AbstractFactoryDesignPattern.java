package com.sarat.designPatterns.creational_Design_Patterns.abstractFactory;


/**
 * <p>****	Abstract Factory Design Pattern	****<p>
 * 
 * Factory of factories. To keep things simple you can understand it like, 
 * you have a set of �related� factory method design pattern. 
 * Then you will put all those set of simple factories inside a factory pattern. 
 * So in turn you need not be aware of the final concrete class that will be instantiated. 
 * 
 * @author Sarat Behera
 *
 */
public class AbstractFactoryDesignPattern {
	
	public static void main(String args[]){
		new Wonderland(createAnimalFactory("water"));
	}

	public static AnimalFactory createAnimalFactory(String type){
		if("water".equals(type))
			return new SeaFactory();
		else
			return new LandFactory();
	}

}
