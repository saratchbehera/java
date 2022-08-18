package com.sarat.designPatterns.behavioral_Design_Patterns.Momento.CopyPaste;

public class Notepad {
	
	private String word;

	public void setword(String word) {
		this.word = word;
	}

	public String getword() {
		return word;
	}

	public Memento createMemento() {
		return new Memento(word);
	}

	public void setMemento(Memento memento) {
		word = memento.getword();
	}
}
