package com.sarat.dataStructures.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

	private Node<Item> itemInTop; //top of the stack
	private int size;		  // size of the stack
	
	//linklist helper
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	public void stack() {
		itemInTop = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return itemInTop == null;
	}
	
	public int size() {
		return size;
	}
	
	public void push(Item item) {
		Node<Item> oldItem = itemInTop;		//we have to save the old item
		itemInTop = new Node<Item>();		//the new element is the new node
		itemInTop.item = item;				
		itemInTop.next = oldItem;
		size++;
	}
	
	public Item pop() {
		if(isEmpty())
			throw new NoSuchElementException("There is no element in the Stack");
		
		Item item = itemInTop.item;				//the first item that needs to be poped up is the item in the top
		itemInTop = itemInTop.next;				//the item in top need to be deleted so assign the next element to itself will do it.
		size--;
		return item;
	}
	
	public Item peek() {
		if(isEmpty())
			throw new NoSuchElementException("There is no element in the Stack to peek from");
		
		return itemInTop.item;
	}
	
	@Override
	public String toString() {
		//we have to iterate this object to get the items.
		StringBuilder sb = new StringBuilder();
		
		//if this class is not implementing iterable then this cannot be iterated. error - Can only iterate over an array or an instance of java.lang.Iterable
		for(Item item : this) {
			sb.append(item);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(itemInTop);
	}
	
	private class ListIterator<Item> implements Iterator<Item>{
		private Node<Item> nextNode;

		public ListIterator(Node<Item> itemInTop) {
			nextNode = itemInTop;
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Item next() {
		
			if(isEmpty())
				throw new NoSuchElementException();
			
			Item item = nextNode.item;
			nextNode = nextNode.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Stack<String> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Choose an option \n\r");		
		System.out.println("1. Push Element \n 2. Pop Element \n 3. See Top Element \n 4. See all the elements in the stack ");
		
		switch (Integer.parseInt(System.in.toString())) {
		case 1:
			
			break;

		default:
			break;
		}
		String item = br.readLine();
		
		System.out.println(item);
		/*if(item != null){
			stack.push(item);
		}*/
	}

	
}
