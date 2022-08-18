package com.sarat.designPatterns.creational_Design_Patterns.Factory;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		
		// creating the factory
		PetFactory petFactory = new PetFactory();

		// factory instantiates an object
		Pet pet = petFactory.getPet("bark");

		// you don't know which object factory created
		System.out.println(pet.speak());
	}

}
