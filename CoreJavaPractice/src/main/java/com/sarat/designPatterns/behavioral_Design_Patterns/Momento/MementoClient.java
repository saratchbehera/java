package com.sarat.designPatterns.behavioral_Design_Patterns.Momento;

public class MementoClient {
	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setState("Lion");
		Memento memento = originator.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(memento);

		originator.setState("Tiger");
		originator.setState("Horse");
		memento = originator.createMemento();
		caretaker.addMemento(memento);
		originator.setState("Elephant");
		System.out
				.println("Originator Current State: " + originator.getState());
		System.out.println("Originator restoring to previous state...");
		memento = caretaker.getMemento(1);
		originator.setMemento(memento);
		System.out
				.println("Originator Current State: " + originator.getState());
		System.out.println("Again restoring to previous state...");
		memento = caretaker.getMemento(0);
		originator.setMemento(memento);
		System.out
				.println("Originator Current State: " + originator.getState());
	}
}
