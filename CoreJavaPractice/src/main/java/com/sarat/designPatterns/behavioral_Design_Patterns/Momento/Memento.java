package com.sarat.designPatterns.behavioral_Design_Patterns.Momento;

public class Memento {
	private String state;
	
	public Memento(String state){
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
