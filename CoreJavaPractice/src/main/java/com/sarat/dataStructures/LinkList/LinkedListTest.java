package com.sarat.dataStructures.LinkList;

public class LinkedListTest {

	public static void main(String[] args) {
		
		// Creating Singly linked list in Java of String type 
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(); 
		singlyLinkedList.append("Java"); 
		singlyLinkedList.append("JEE"); 
		singlyLinkedList.append("Android "); 
		
		//singlyLinkedList.append(2);		// compile time error 
		
		System.out.println("Singly linked list contains : " + singlyLinkedList); 		System.out.println("length of linked list : " + singlyLinkedList.length()); 		System.out.println("is this linked list empty : " + singlyLinkedList.isEmpty()); 
		
		SinglyLinkedList iList = new SinglyLinkedList(); 
		iList.append(202); 
		iList.append(404); 
		//iList.append("one"); // compilation error - Trying to insert String on integer list 
		
		System.out.println("linked list : " + iList); 
		System.out.println("length : " + iList.length());
		
	}

}
