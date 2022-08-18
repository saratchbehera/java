package com.sarat.designPatterns.creational_Design_Patterns.abstractFactory;

public class Wonderland {

	public Wonderland(AnimalFactory factory) {
		Animal animal = factory.createAnimal();
		animal.breathe();
	}
}
