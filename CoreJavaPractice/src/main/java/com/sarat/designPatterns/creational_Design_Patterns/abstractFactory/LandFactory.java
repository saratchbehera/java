package com.sarat.designPatterns.creational_Design_Patterns.abstractFactory;

public class LandFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Elephant();
	}

}
