package com.sarat.java8.lamdaExpressions;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {

	BinaryOperator<Integer> add = (a, b) -> a+b;
	
	public static void main(String[] args) {
		
		//With BinaryOperator
		BinaryOperatorTest bot = new BinaryOperatorTest();
		
		System.out.println(bot.add.apply(5, 7));
		
		
		//Without BinaryOperator
		AddOperation add = (int a, int b) -> a+b;
		
		System.out.println(add.operation(5, 7));
		
		
		
	}
	
	/**
	 * without BinaryOperator
	 * @author saratchandrabehera
	 *
	 */
	@FunctionalInterface
	public interface AddOperation{
		
		int operation(int a, int b);
	}

}
