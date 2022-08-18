package com.sarat.test;

import java.util.ArrayList;
import java.util.List;

public class Sarat {

	public static void main(String[] args) {

		List<String> a = new ArrayList<>();		
		a.add("Asim");a.add("Ashesh");
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("Sarat");a1.add("Sumit");
		m1(a);
		m1(a1);
		//m2(a);  x
		m2((ArrayList<String>) a);
		m2(a1);
	}

	public static void m1(List<String> a) {
		System.out.println(a);
	}

	public static void m2(ArrayList<String> a) {
		System.out.println(a);
	}
}