package com.sarat.designPatterns.structural_Design_Patterns.Decorator;

public class NuttyDecorator extends IcecreamDecorator{

	public NuttyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}
	
	@Override
	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addNuts();		
	}

	private String addNuts() {
		return " + cruncy nuts";
	}

}
