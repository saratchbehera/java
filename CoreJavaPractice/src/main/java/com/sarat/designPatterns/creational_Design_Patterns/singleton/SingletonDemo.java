package com.sarat.designPatterns.creational_Design_Patterns.singleton;

public class SingletonDemo implements Cloneable{
	
	private static SingletonDemo sin;

	private SingletonDemo(){}	
	
	public synchronized static SingletonDemo getInstance(){
		
		if(sin == null){
			sin = new SingletonDemo();//Till Java 7
			//sin = SingletonDemo::new;
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
