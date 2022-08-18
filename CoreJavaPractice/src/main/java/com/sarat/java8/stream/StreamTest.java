package com.sarat.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class StreamTest {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i < 1_00_000; i++) {
			numbers.add(i);
		}
		
		System.out.println("Imperative style :: "+numbers);
		
		
		List<Integer> evenNumbers = numbers.stream()
											.filter(n -> n % 2 == 0)
											.collect(toList());
		
		List<String> mafValues = Arrays.asList("[25-402n", "25-402o", "25-402p");
		
		mafValues = mafValues.stream().map(e -> e.startsWith("[") ? e.substring(1) : e)
				.collect(Collectors.toList());
				 
		System.out.println(mafValues);
		
		System.out.println("[25-402n".substring(1));
	}

}
