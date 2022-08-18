package com.sarat.java8.comparator;

public class Person {
	
	private final String name;
	private final int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return String.format("%s -- %d", name, age);
	}
	
}
