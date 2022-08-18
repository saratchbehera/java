package com.sarat.designPatterns.creational_Design_Patterns.builder;


/**
 * <p>****	Builder Design Pattern	****<p>
 * 
 * Builder pattern is used to construct a complex object step by step 
 * and the final step will return the object. 
 * The process of constructing an object should be generic 
 * so that it can be used to create different representations of the same object.
 * 
 * <p>For example,<p> 
 * 
 * you can consider construction of a home. 
 * Home is the final end product (object) that is to be returned as the output of the construction process.
 * It will have many steps, like basement construction, wall construction and so on roof construction. 
 * Finally the whole home object is returned. 
 * Here using the same process you can build houses with different properties.
 * 
 * @author Sarat Behera
 *
 */
public class BuilderDesignPattern {

	public static void main(String[] args) {
		
		BeheraHouseBuilder beheraBuilder = new BeheraHouseBuilder();
		//or 
		//TipiHouseBuilder tipiBuilder = new TipiHouseBuilder();
		//CivilEngineer engineer = new CivilEngineer(tipiBuilder);
		
		CivilEngineer engineer = new CivilEngineer(beheraBuilder);

		engineer.constructHouse();

		House house = engineer.getHouse();

		System.out.println("Builder constructed: "+house);
	}

}
