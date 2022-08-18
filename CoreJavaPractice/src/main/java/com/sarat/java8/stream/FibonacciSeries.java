package com.sarat.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		IntStream.iterate(0, i -> i + 2)
		.limit(5).forEach(System.out::println);
		
		
		//0, 1
		//1, 1
		//1, 2
		//2, 3
		//3 ,5
		//get the first element form the left
		Stream.iterate(new int[]{0,1},e->new int[]{e[1],e[0]+e[1]})
		  .limit(10)
		  .map(n->n[0]) 
		  .collect(Collectors.toList()).forEach(System.out::println); 
	}

}
