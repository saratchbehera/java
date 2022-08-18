package com.sarat.java8.lamdaExpressions;

import java.util.Arrays;
import java.util.List;

public class ListPrint {

	public static void main(String[] args) {
	
		List<String> a = Arrays.asList("Sarat","Kiran");
		
		a.forEach(System.out::println);
	}

}
