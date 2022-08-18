package com.sarat.designPatterns.behavioral_Design_Patterns.Iterator;

import java.util.Arrays;
import java.util.List;

public class IteratorDesignPatternTest {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//External iterator
		//Here we are deciding how to iterate the collection
	/*	for(int i : numbers) {
			System.out.println(i);
		}*/
		
		//Internal Iterator
		//Here we concentrate what is the login that we want to execute rather than how to iterate
		numbers.forEach(e -> System.out.println(e));
		numbers.forEach(System.out::println);
	}
}
