package com.sarat.exception;

import java.util.Scanner;

public class BankDemo {

	public static void main(String[] args) {
		CheckingAccount account = new CheckingAccount(101);
		
		//BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    //String s = bufferRead.readLine();
		System.out.print("Enter the Deposit amount and press enter : ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String depositAmount = scanner.nextLine();
		
		System.out.println("Depositing Rs."+ depositAmount + " to Account "+ account.getNumber());
				account.deposit(Double.parseDouble(depositAmount));
		
		try {
			System.out.println("Enter the Withdraw Amount and press enter : ");
			String withdrawAmount = scanner.nextLine();
			
			account.withdraw(Double.parseDouble(withdrawAmount));
			
			System.out.println("Withdrawing : Rs."+withdrawAmount);
		} catch (InsufficientFundsException e) {
			System.out.println("Sorry, but you are short Rs."+ e.getAmount());
			e.printStackTrace();
		}

	}

}
