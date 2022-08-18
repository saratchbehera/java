package com.sarat.java8.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {

	public static void main(String[] args) {
		
		List<String> fruits = Arrays.asList("Apple", "Orange", "Grapes", "Pineapple", "Tomato");
		
		//need to filter out fruits from vegetable 
		List<String> result = fruits.stream()
									.filter(line -> !"Tomato".equals(line))
									.collect(Collectors.toList());
		
		result.forEach(System.out::print);
		
		System.out.println("Fruits :: "+ result);
		//System.out.println("Vegetable :: "+ ListUtils.subtract(fruits, result));
	}

}
