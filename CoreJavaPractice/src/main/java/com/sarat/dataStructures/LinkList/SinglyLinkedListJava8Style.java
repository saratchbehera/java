package com.sarat.dataStructures.LinkList;

public class SinglyLinkedListJava8Style<T> {

	private Node head;
	
	public int length() {
		
		int length = 0;
		Node current = head;
		
		while(current != null) {
			length++;
			current = current.next;
		}
		return length;
	}
	
	public boolean isEmpty() {
		return length()==0;
	}
	
	private Node tail() {
		
		Node tail = head;
		
		while(tail.next !=null) {
			tail = tail.next;
		}
		return tail;
		
	}
	
	public void append(T data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		tail().next = new Node(data);
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder(); 
		Node current = head; 
		
		while(current != null){
			sb.append(current).append(" > "); 
			current = current.next; 
		}
		
		return sb.toString();
	}

	// Node is nested static class because it only exists along with linked list 
	// Node is private because it's implementation detail, and should not be exposed
	private static class Node<T>{
		
		private Node next;
		private T data;
		
		public Node(T data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data.toString();
			
		}
	}
}
