package com.sarat.java8.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorTest {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Sarat", 28),
				new Person("Sumit", 23),
				new Person("Rama", 28),
				new Person("Abhijit", 29));
		
		/*Comparator<Person> comparator = new Comparator<Person>(){

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};*/
		
		//Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		
		
		//printSorted(people, comparator);
		System.out.println("Comparing based on Name");
		printSorted(people, comparing(Person::getName));
		
		System.out.println();

		System.out.println("Comparing based on Age");
		printSorted(people, comparing(Person::getAge));
		
		System.out.println();
		
		System.out.println("Comparing based on Age then name");
		printSorted(people, comparing(Person::getAge).thenComparing(Person::getName));
	}
	
	public static void printSorted(List<Person> people, Comparator<Person> comparator){
		people.stream()
			  .sorted(comparator)
			  .forEach(System.out::println);
	}

}
