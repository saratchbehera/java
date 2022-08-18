package com.sarat.designPatterns.behavioral_Design_Patterns.Strategy;

import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyGOFJava8Style {
	
	public static void publishText(String text, Predicate<String> filter, Function<String, String> format) {
		
		if(filter.test(text)) {
			System.out.println(format.apply(text));
		}
	}

	public static void main(String[] args) {
		publishText("ERROR - Something is wrong", 
				text -> text.startsWith("ERROR"), //condition
				String::toUpperCase); // logic based on condition
	}

}
 