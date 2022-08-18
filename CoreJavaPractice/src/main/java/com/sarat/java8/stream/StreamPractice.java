package com.sarat.java8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		//sort the list and convert it to uppercase.
		myList.stream().map(e -> e.toUpperCase())
				.sorted()
		.collect(Collectors.toList())
		.forEach(System.out::println);							

		System.out.println();		
		
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);;
		
		System.out.println();
		
		Stream<String> streamOfArrays = Stream.of("a1", "a2", "a3");
		
		//Stream of arrays
		String[] arr = new String[] {"A", "B"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> addedStream = Arrays.stream(arr, 1, 2); // only include B in the stream
		Arrays.stream(arr, 1, 2).forEach(System.out::println); // only include B in the stream
		
		//Empty Stream
		Stream<String> aStream = Stream.empty(); //Returns a empty stream
		
		//Stream of Collection
		Collection<String> collectionOfStream = Arrays.asList("A", "B", "C");
		Stream<String> aStream2 = collectionOfStream.stream(); //.stream() apply to a collection will convert a collection to stream.
		
	
		//Stream builder
		System.out.println("Stream builder examples");
		Stream<String> streamBuilder = Stream.<String>builder().add("A").add("B").add("C").build();
		streamBuilder.forEach(System.out::print);
	
		//Stream generate 
		/**
		 * The generate() method accepts a Supplier<T> for element generation. 
		 * As the resulting stream is infinite, developer should specify the desired size or 
		 * the generate() method will work until it reaches the memory limit:
		 */
		System.out.println("\n\nStream Generate");
		Stream<String> streamGenerated = Stream.generate(() -> "Sarat").limit(5);
		streamGenerated.forEach(System.out::println);
		
		/**
		 * Stream.iterate()
		 * Another way of creating an infinite stream is by using the iterate() method:
		 */
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(5);
		streamIterated.forEach(System.out::println);
		
		/**
		 * Stream of String
		 * String can also be used as a source for creating a stream.
		 * With the help of the chars() method of the String class. 
		 * Since there is no interface CharStream in JDK, the IntStream is used to represent a stream of chars instead.
		 */
		System.out.println();
		IntStream streamOfChars = "A".chars();
		streamOfChars.forEach(System.out::print); //"S" = 83 "A" = 65
		
		/**
		 * Stream of File
		 * Java NIO class Files allows to generate a Stream<String> of a text file through the lines() method. 
		 * Every line of the text becomes an element of the stream:
		 */
		
		//http://www.baeldung.com/reading-file-in-java
		//Path path = Paths.get(ClassLoader.getSystemClassLoader());
		//System.out.println(Paths.get(getClass().getClassLoader().getResource("sarat.txt").toURI().toString()));
	}
}
