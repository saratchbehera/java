package com.sarat.test;

public class BinaryToDecimalExample1 {
	public static void main(String args[]) {
		
		String binaryString = "10010";
		System.out.println(Integer.toBinaryString(18));
		System.out.println(Integer.parseInt(Integer.toBinaryString(18)) >> 1);
		int decimal = Integer.parseInt(binaryString, 2);
		System.out.println(decimal);
		
		Integer i = -9;
		System.out.println(Integer.toBinaryString(i));
		System.out.println( i >> 1);
		System.out.println(i +" - "+ (i >>> 1));
		System.out.println( i << 1);
		System.out.println( i << 1);
		
	}
}