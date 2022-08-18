package com.sarat.designPatterns.creational_Design_Patterns.singleton;


public class SingletonDemoTest {

	public static void main(String[] args) {
		
		SingletonDemo singletonDemo = SingletonDemo.getInstance();
				
		System.out.println("singletonDemo.hashCode() -- "+ singletonDemo.hashCode());
		System.out.println("singletonDemo.hashCode() -- "+ singletonDemo.hashCode());
		System.out.println("singletonDemo.hashCode() -- "+ singletonDemo.hashCode());
		System.out.println("singletonDemo.hashCode() -- "+ singletonDemo.hashCode());
		 
	}
}
