package com.sarat.designPatterns.creational_Design_Patterns.abstractFactory;

public class SeaFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Shark();
	}
}
