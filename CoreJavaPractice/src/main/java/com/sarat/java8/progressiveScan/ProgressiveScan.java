package com.sarat.java8.progressiveScan;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProgressiveScan {
	
	public static void main(String[] args) {
		
		String x = "the best of the best of the best of the";
		
		System.out.println(Pattern.compile("\\s")
		.splitAsStream(x)
		.collect(Collectors.groupingBy(String::toString, Collectors.counting())));
		
		
}

}
