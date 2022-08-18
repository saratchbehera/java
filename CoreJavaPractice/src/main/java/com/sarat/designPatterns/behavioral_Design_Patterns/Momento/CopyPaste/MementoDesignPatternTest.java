package com.sarat.designPatterns.behavioral_Design_Patterns.Momento.CopyPaste;

public class MementoDesignPatternTest {
	
	public static void main(String[] args) {
		
		Notepad notepad = new Notepad();
		notepad.setword("Sarat");
		
		Memento memento = notepad.createMemento();
		
		TempMemory tempMemory = new TempMemory();
		tempMemory.addMemento(memento);

		notepad.setword("Sandeep");
		notepad.setword("Poornima");
		
		memento = notepad.createMemento();
		tempMemory.addMemento(memento);
		
		notepad.setword("Sumit");
		
		System.out.println("Notepad Current Word: " + notepad.getword());
		System.out.println("Notepad restoring to previous word...");
		
		memento = tempMemory.getMemento(1);
		notepad.setMemento(memento);
		
		System.out.println("Notepad Current Word: " + notepad.getword());
		System.out.println("Again restoring to previous word...");
		
		memento = tempMemory.getMemento(0);
		notepad.setMemento(memento);
		
		System.out.println("Notepad Current Word: " + notepad.getword());
	}
}
