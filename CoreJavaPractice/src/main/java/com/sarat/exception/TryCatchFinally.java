package com.sarat.exception;

/**
 * 
 * Finally Block will always execute if system.exit(0) statement is not there.
 * @author Sarat Behera
 *
 */
public class TryCatchFinally {

	public static void main(String[] args) {
		
		try{
			System.out.println("Hi Try");
			throw new NumberFormatException();
		}catch(NumberFormatException ne){
			System.out.println("1st Catch");
			//return;
			//System.exit(0);
		}catch(Exception e){
			System.out.println("2nd Catch");
		}
		finally{
			System.out.println("Bye in Finally");
		}

	}

}
