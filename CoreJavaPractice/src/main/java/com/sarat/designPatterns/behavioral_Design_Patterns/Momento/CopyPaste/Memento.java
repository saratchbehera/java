package com.sarat.designPatterns.behavioral_Design_Patterns.Momento.CopyPaste;

public class Memento {
	
	private String word;
	
	public Memento(String word){
		this.word = word;
	}

	public String getword() {
		return word;
	}

	public void setword(String word) {
		this.word = word;
	}

}
