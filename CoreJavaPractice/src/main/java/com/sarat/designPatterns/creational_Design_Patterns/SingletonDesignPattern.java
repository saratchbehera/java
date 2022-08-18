package com.sarat.designPatterns.creational_Design_Patterns;

/**
 * 
 * @author Sarat Chandra Behera
 *
 *	Definition of a singleton design pattern
 *
 *	1.	There should be only one instance allowed for a class.
 *	2.	we should allow global point of access to that single instance.
 *
 */
public class SingletonDesignPattern implements Cloneable {

	
	private static SingletonDesignPattern sin;

	private SingletonDesignPattern(){}	
	
	public synchronized static SingletonDesignPattern getInstance(){
		
		if(sin == null){
			sin = new SingletonDesignPattern();
		}
		
		return sin;
	}
	
	
	@SuppressWarnings("unused")
	protected Object clone() throws CloneNotSupportedException {
		
		if(true)
		{
			throw new CloneNotSupportedException("Singleton Class not able to Clone");
		}
		
		return super.clone();
	}

}
