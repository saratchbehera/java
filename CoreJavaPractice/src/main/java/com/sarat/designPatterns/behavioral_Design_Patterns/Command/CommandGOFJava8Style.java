package com.sarat.designPatterns.behavioral_Design_Patterns.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandGOFJava8Style {
	
	public static void log(String message) {
		System.out.println("Logging :: "+ message);
	}
	public static void save(String message) {
		System.out.println("saving :: "+ message);
	}
	public static void send(String message) {
		System.out.println("sending :: "+ message);
	}	
	
	public static void execute(List<Runnable> tasks) {
		tasks.forEach(Runnable::run);
	}

	public static void main(String[] args) {
		List<Runnable> tasks = new ArrayList<>();
		tasks.add(() -> log("Hi"));
		tasks.add(() -> save("Cheers"));
		tasks.add(() -> send("Bye"));
		
		execute(tasks);

	}

}
