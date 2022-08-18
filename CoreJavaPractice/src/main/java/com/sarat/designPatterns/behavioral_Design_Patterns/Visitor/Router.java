package com.sarat.designPatterns.behavioral_Design_Patterns.Visitor;

public interface Router {

	public void sendData(char[] data);
	public void acceptData(char[] data);
	
	public void accept(RouterVisitor routerVisitor);
}
