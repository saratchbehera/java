package com.sarat.designPatterns.behavioral_Design_Patterns.Visitor;

public class TPLinkRouter implements Router {

	@Override
	public void sendData(char[] data) {

	}

	@Override
	public void acceptData(char[] data) {
	
	}

	@Override
	public void accept(RouterVisitor routerVisitor) {
		routerVisitor.visit(this);
	}

}
