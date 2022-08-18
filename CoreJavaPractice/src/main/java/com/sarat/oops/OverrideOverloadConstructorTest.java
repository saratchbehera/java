package com.sarat.oops;

class OverloadC{
	
	public OverloadC() {
		System.out.println("In OverloadC m1()");
	}	
	public OverloadC(String m) {
		System.out.println("In OverloadC m1(String m)" + m);
	}
}
class ChildC extends OverloadC{
	public ChildC() {
		System.out.println("In ChildC Overload m1()");
	}
	
	public ChildC(String m) {
		super();
		System.out.println("In ChildC Overload m1(String m)" + m);
	}
}
public class OverrideOverloadConstructorTest {

	public static void main(String[] args) {
		OverloadC child = new ChildC();
	}
}

