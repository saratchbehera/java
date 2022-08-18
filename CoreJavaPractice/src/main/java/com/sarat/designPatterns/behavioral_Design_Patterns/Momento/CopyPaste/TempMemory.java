package com.sarat.designPatterns.behavioral_Design_Patterns.Momento.CopyPaste;

import java.util.ArrayList;

public class TempMemory {
	
	private ArrayList<Memento> wordList = new ArrayList<Memento>();

	public void addMemento(Memento m) {
		wordList.add(m);
	}

	public Memento getMemento(int index) {
		return wordList.get(index);
	}
}
