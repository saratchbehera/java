package com.sarat.test;

import java.util.ArrayList;

class A<T>{
	T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}	
}
@SuppressWarnings("rawtypes")
public class Generic extends A{

	public static void main(String[] args) {
		A<String> a = new A<String>();
		A<ArrayList<Integer>> b = new A<ArrayList<Integer>>();
		
		int x = 5;
		Integer y = x;
		Object o = x;
		x = (int) o;
		x = y;
		
		

	}

}
