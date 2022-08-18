package com.sarat.designPatterns.structural_Design_Patterns.Decorator;

/**
 * 
 * <b><p>Decorator Design Pattern</p></b>
 * <p>To extend or modify the behavior of <b>�an instance�</b> at runtime decorator design pattern is used. 
 * Inheritance is used to extend the abilities of �a class�. 
 * But unlike inheritance, you can choose any single object of a class and modify its behavior 
 * leaving the other instances unmodified.</p>
 * 
 * <b>Example</b>
 * <p>Icecream is a classic example for decorator design pattern. 
 * You create a basic icecream and then add toppings to it as you prefer. 
 * The added toppings decorate and change the taste of the basic icecream. 
 * You can add as many topping as you want.</p>
 * 
 *  <p>In this example {@link IcecreamDecorator} is the core of this design patterns.</p>
 * 
 * @author Sarat Behera
 *
 */
public class TestDecorator {

	public static void main(String[] args) {
		Icecream icecream = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
	    System.out.println(icecream.makeIcecream());
	}

}
