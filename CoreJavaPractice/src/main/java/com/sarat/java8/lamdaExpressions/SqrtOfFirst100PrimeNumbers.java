package com.sarat.java8.lamdaExpressions;

import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SqrtOfFirst100PrimeNumbers {

	public static void main(String[] args) {
		
		System.out.println(Calendar.getInstance().getTimeInMillis());
		List<Double> SqrtOfFirst100Primes = 
				Stream.iterate(1, e -> e + 1) //for iterating infinite numbers
					  .filter(SqrtOfFirst100PrimeNumbers::isPrime)
					  .limit(10)
					  .map(t -> Math.sqrt(t))
					  .collect(toList());
		
		SqrtOfFirst100Primes.forEach(System.out::println);
		
		System.out.println(SqrtOfFirst100Primes.size());
		System.out.println(Calendar.getInstance().getTimeInMillis());								
		
		IntStream.iterate(1, e -> e + 1)
		  .filter(SqrtOfFirst100PrimeNumbers::isPrime2)
		  .limit(10)
		  .map(t -> (int) Math.sqrt(t))
		  .forEach(System.out::println);
		
		System.out.println(Calendar.getInstance().getTimeInMillis());
	}
	
	public static boolean isPrime(int number){
		return number > 1 && IntStream.range(2, number) //iterate few in range
										.allMatch(e -> number%e != 0);
									  //.noneMatch(e -> number%e == 0);
	}

	public static boolean isPrime2(int number){
		return number > 1 && IntStream.range(2, number)
										//.allMatch(e -> number%e != 0);
									  .noneMatch(e -> number%e == 0);
	}
}
