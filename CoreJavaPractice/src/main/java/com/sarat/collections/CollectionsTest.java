package com.sarat.collections;

import java.util.*;


/**
 * Collection is an interface. There are mainly 3 types of collections
 * 
 * ** COLLECTION( INTERFACE ) **
 * 
 * 1. List ( Interface )
 * 
 * 		a. ArrayList ( Class )
 * 		b. Vector ( Class )
 * 		c. LinkedList ( Class )
 * 
 * 2. Set ( Interface )
 * 
 * 		a. HashSet  ( Class )
 * 		b. LinkedHashSet  ( Class )
 * 		c. TreeSet  ( Class )
 * 		d. SortedSet  ( Interface )
 * 
 * 3. Queue ( Interface )
 * 
 * 		a. PriorityQueue ( Class )
 * 
 * 
 *  ** MAP( INTERFACE ) ** Map is not a part of collection.
 *  
 *  	a. HashMap  ( Class )
 *  	b. HashTable  ( Class )
 *  	c. LinkedHashMap  ( Class )
 *  	d. TreeMap  ( Class )
 *  	e. SortedMap   ( Interface )
 *  
 *  @author SARAT
 */
public class CollectionsTest {

	public static void main(String[] args) {
		

		/**
		 * ArrayList implements List interface.
		 * ArrayList is ordered, not synchronized, accepts NULL and accepts duplicate values. 
		 */
		List<Integer> arrayList = new ArrayList<Integer>(); 
		
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(null);
		arrayList.add(3);		
		
		System.out.println("ArrayList  -- "+ arrayList);
		System.out.println("\n -- Iterate ArrayList --\n"); 
		
		Iterator<Integer> iteratorarrayList = arrayList.iterator();
		
		while(iteratorarrayList.hasNext()){
			System.out.print(iteratorarrayList.next() + ","); 
		}
		
				
		/**
		 * HashSet implements Set Interface.
		 * HashSet is unordered, not synchronized, accepts NULL and DOES NOT accepts duplicate values. 
		 */
		Set<Object> hashset = new HashSet<Object>(); 
		
		hashset.add("a"); 
		hashset.add(0); 
		hashset.add("c");
		hashset.add(null);
		hashset.add("c");
		
		System.out.println("\n\n HashSet -- "+ hashset);
		System.out.println("\n -- Iterate ArrayList --\n");
		
		Iterator<Object> iteratorHashSet = hashset.iterator();
		
		while(iteratorHashSet.hasNext()){
			System.out.print(iteratorHashSet.next() + ","); 
		}
		
		
		
		/**
		 * HashMap implements Map interface.
		 * HashMap is unordered, not synchronized, accepts NULL and DOES NOT accepts duplicate values.
		 * HashMap has 2 sets. one is keySet and another is entitySet.
		 */
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(0, "a");
		hashMap.put(0, "b");
		hashMap.put(0, "a");
		hashMap.put(4, "b");
		hashMap.put(2, "c");
		hashMap.put(null,"key - null");
		hashMap.put(null, "key -2nd  null");
		hashMap.put(1, null);
		hashMap.put(0, "Z"); 
		
		System.out.println("\n\n HashMap  -- " + hashMap);
		System.out.println("\n -- Iterate HashMap --\n");
		
		 Iterator<Integer> iteratorHashMap = hashMap.keySet().iterator();
		 while(iteratorHashMap.hasNext()){
			 String val = (String) hashMap.get(iteratorHashMap.next());
			 System.out.print(val + ",");
		}
		
		 hashMap = Collections.synchronizedMap(hashMap);
		 
		 
		 
		 /**
			 * HashTable implements Map interface.
			 * HashTable is unordered, synchronized, DOESNOT accepts NULL and DOES NOT accepts duplicate values.
			 * HashTable has 2 sets. one is keySet and another is entitySet.
			 */
			Map<Integer, String> hashTable = new Hashtable<Integer, String>();
			
			hashTable.put(0, "a");
			hashTable.put(1, "b");
			hashTable.put(2, "c");		
			hashTable.put(0, "Z"); 
			
			System.out.println("\n\n HashTable  -- " + hashTable);
			System.out.println("\n -- Iterate HashTable --\n");
			
			 Iterator<Integer> iteratorHashTable = hashTable.keySet().iterator();
			 while(iteratorHashTable.hasNext()){
				 String val = (String) hashTable.get(iteratorHashTable.next());
				 System.out.print(val + ",");
			}
			 
			 
			 /**
				 * TreeMap implements Map interface.
				 * TreeMap is unordered, DOESNOT accepts NULL and DOES NOT accepts duplicate values.
				 * TreeMap has 2 sets. one is keySet and another is entitySet.
				 */
			 TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
				
			 treeMap.put(0, "a");
			 treeMap.put(1, "b");
			 treeMap.put(2, "c");		
			 treeMap.put(0, "Z"); 
				
				System.out.println("\n\n treeMap  -- " + treeMap);
				System.out.println("\n -- Iterate treeMap --\n");
				
				 Iterator<Integer> iteratorTreeMap = treeMap.keySet().iterator();
				 while(iteratorTreeMap.hasNext()){
					 String val = (String) treeMap.get(iteratorTreeMap.next());
					 System.out.print(val + ",");
				}
			 
	}

}
