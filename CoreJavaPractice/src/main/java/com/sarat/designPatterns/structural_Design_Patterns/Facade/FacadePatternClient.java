package com.sarat.designPatterns.structural_Design_Patterns.Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FacadePatternClient {

	private static int choice;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		do {
			System.out.println("-------Mobile Shop-------");
			System.out.println("1.Iphone");
			System.out.println("2.Samsung");
			System.out.println("3.Exit");
			
			System.out.println("Enter your choice : ");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(reader.readLine());
			Shopkeeper sk = new Shopkeeper();
			
			
		switch(choice) {
		case 1:sk.iphoneSale();break;
		case 2:sk.samsungSale();break;
		case 3:System.exit(0);
		
		default: System.out.println("You have purchased nothing");
		}
	}while(choice!=4);
	}

}
