package com.sarat.designPatterns.behavioral_Design_Patterns.Strategy.SumOfIntegers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyDesignPatternJava8StyleTest {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//sum of all values, sum of odd values and sum of even values		
		//Normal functions vs higher order function
		//A normal function takes an object as a parameter and return an object
		//A higher order function may recieve a function as an argument and return a function.
		
		System.out.println(totalValues(numbers, e -> true));
		System.out.println(totalValues(numbers, e -> e % 2 == 0));
		System.out.println(totalValues(numbers, e -> e % 2 != 0));
		
		System.out.println(totalValues(numbers, Util::isEven));
		System.out.println(totalValues(numbers, Util::isOdd));
	}

	private static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
		
		/*int result = 0;
		
		for(int e: numbers) {
			if(selector.test(e)) {
				result +=e;
			}
		}

		return result;*/
		
		//return numbers.stream().filter(selector).reduce(0, Integer::sum);
		
		return numbers.stream()
						.filter(selector)
						.mapToInt(e -> e)
						.sum();
	}

}


class Util {
	
	public static boolean isEven(int number) {
		return number % 2 == 0;
	}
	
	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}
}