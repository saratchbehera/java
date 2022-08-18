package com.sarat.designPatterns.creational_Design_Patterns.Factory;

//sub class 2 that might get instantiated by a factory method pattern
public class Duck implements Pet {
	public String speak() {
		return "Quack quack...";
	}
}
