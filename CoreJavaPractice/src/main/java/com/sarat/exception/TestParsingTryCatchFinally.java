package com.sarat.exception;

public class TestParsingTryCatchFinally {

	public static void main(String[] args) {
		TestParsingTryCatchFinally t = new TestParsingTryCatchFinally();
		t.method1("1.0");
	}

	public void method1(String s){
		Float f = null;
		try{
			f = Float.parseFloat(s);
		}catch(NumberFormatException e){
			System.out.println(" f : "+f);
		}finally{
			f=(float) 5.0;
			System.out.println("f : "+f);
		}
	}
}
