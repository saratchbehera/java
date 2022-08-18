package com.sarat.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByMaxPrice {

	public static void main(String[] args) {
		List<Dress> dresses = Arrays.asList(new Dress("S", "RED", "Shirt", 10), 
											new Dress("S", "RED", "Pant", 20),
											new Dress("M", "RED", "Shirt", 30), 
											new Dress("L", "BLUE", "Shirt", 40),
											new Dress("XL", "BLUE", "Shirt", 50), 
											new Dress("XL", "BLUE", "Pant", 60),
											new Dress("XXL", "GREEN", "Sweater", 70));
		
		//Question find all the high price pieces for each color
		//{RED=Dress [size=M, color=RED, name=Shirt, price=30], 
		//BLUE=Dress [size=XL, color=BLUE, name=Pant, price=60], 
		//GREEN=Dress [size=XXL, color=GREEN, name=Sweater, price=70]}

		dresses.stream().collect(Collectors.groupingBy(Dress::getColor, Collectors.minBy(new Comparator<Dress>() {

			@Override
			public int compare(Dress o1, Dress o2) {
				//return Math.max(o1.getPrice(), o2.getPrice());
				//return (o1.getPrice() > o2.getPrice())? o1.getPrice() : o2.getPrice();
				return (o1.getPrice() > o2.getPrice())? -1 : 1;
			}
		}))).entrySet().forEach(e -> System.out.println(e.getKey()+ " :: " +e.getValue().get()));
		
		System.out.println();
		
		System.out.println(dresses.stream().collect(Collectors.groupingBy(Dress::getColor, 
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dress::getPrice)), Optional::get))));
		
	}
	
	
	


}

class Dress{
	
	String size;
	String color;
	String name;
	int price;
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Dress(String size, String color, String name, int price) {
		super();
		this.size = size;
		this.color = color;
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return "[" + this.size + " : " + this.color + " : " + this.name + " : " + this.price + "]";
	}
	
}
