package com.sarat.string;

/**
 * String is not a primitive type in JAVA, it's an OBJECT type.
 * 		- String is immutable objects.
 * 
 * StringBuffer is mutable objects and Synchronized.
 * StringBuilder is mutable objects and non-Synchronized.
 * 
 * @author SARAT
 */
public class String_StringBuffer_StringBuilder {

	public static void main(String[] args) {
		
	/**
	 * IMPORTANT FACTS ABOUT STRINGS AND MEMORY
	 * 
	 * One of the key goal of any of the good programming language is to make efficient use of MEMORY.
	 * 
	 * To make JAVA more MEMORY efficient, JVM sets aside a special area of memory called the "STRING CONSTANT POOL".
	 * 
	 *    **STRING CONSTANT POOL**
	 *    When the compiler encounters a string literal, it checks the pool if an identical string already exists.
	 *    If a match is found, the reference to the new literal is directed to the existing string.
	 *    So no new string literal is created( The existing string simply has an additional reference ).
	 *    
	 *  STRING class is Final, so you cannot override the functionality of String.
	 *  
	 *  so the same string has any number of reference.
	 *  That is the main reason why STRING is IMMUTABLE.
	 *  
	 *  ***********************************************************************************************************
	 *  
	 *
	 * A String literal is a java language concept. This is a String literal:
	 * "a String literal"
	 * 
	 * A String object is an individual instance of the java.lang.String class.
	 * the below string declarations are all valid but have a slight difference: 
	 * s1 will refer to an interned String object. 
	 * This means, that the character sequence "abcde" will be stored at a central place and 
	 * whenever the same literal "abcde" is used again, 
	 * the JVM will not create a new String object but use the reference of the 'cached' String. 
	 * s2 is guaranteed to be a new String object, so in this case we have:
	 * 
	 **/

			String s1 = "abcde";
			String s2 = new String("abcde");
			String s3 = "abcde";
			String s4 = new String("abcde");
			String s5 = new String("abcd");
			
			if(s4 == s5){
				System.out.println("s4 == s5");
			}else{
				System.out.println("s4 != s5");
			}
			
			if(s4 == s2){
				System.out.println("s4 == s2");
			}else{
				System.out.println("s4 != s2");
			}
			
			if(s1 == s2){
				System.out.println("s1 = s2");
			}else{
				System.out.println("s1 != s2");
			}
			
			
			if (s1 == s3) {
				System.out.println("s1 = s3");
			}else{
				System.out.println("s1 != s3");
			}
			
			
			if (s1.equals(s2)) {
				System.out.println("s1.equals(s2)");
			}else{
				System.out.println("s1 not equals to (s2)");
			}
			
			String_StringBuffer_StringBuilder obj1 = new String_StringBuffer_StringBuilder();
			String_StringBuffer_StringBuilder obj2 = new String_StringBuffer_StringBuilder();
			//obj2 = obj1;
			
			if(obj1.equals(obj2)){
				System.out.println("obj1 = obj2");
			}else{
				System.out.println("obj1 != obj2");
			}
	}

}
