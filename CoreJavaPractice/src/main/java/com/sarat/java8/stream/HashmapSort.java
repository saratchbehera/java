package com.sarat.java8.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashmapSort {

	public static void main(String[] args) {
		 
		Map<String, Integer> unsortMap = new LinkedHashMap<>();
	        unsortMap.put("z", 10);
	        unsortMap.put("b", 5);
	        unsortMap.put("a", 6);
	        unsortMap.put("c", 20);
	        unsortMap.put("d", 1);
	        unsortMap.put("e", 7);
	        unsortMap.put("y", 8);
	        unsortMap.put("n", 99);
	        unsortMap.put("g", 50);
	        unsortMap.put("a", 10);
	        unsortMap.put("f", 9);

	        System.out.println("Original Map :: "+ unsortMap);
	        System.out.println("------Order by Key-------");
	        Map<String , Integer> result = 
	        		unsortMap.entrySet().stream()
	        							.sorted(Map.Entry.comparingByKey())
	        							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	        								   (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	        
	        System.out.println("Result 1 Order by Key :: "+ result);
	        
	        Map<String , Integer> result2 = new LinkedHashMap<>();
	        		unsortMap.entrySet().stream()
	        							.sorted(Map.Entry.comparingByKey())
	        							.forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
	        System.out.println("Result 2 Order by Key :: "+ result2);
	        
	        System.out.println("------Order by Value-------");
	        
	        Map<String , Integer> result3 = 
	        		unsortMap.entrySet().stream()
	        							.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	        							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	        								   (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	        
	        System.out.println("Result 3 Order by Value :: "+ result3);
	        
	        Map<String , Integer> result4 = new LinkedHashMap<>();
	        		unsortMap.entrySet().stream()
	        							.sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
	        							.forEachOrdered(x -> result4.put(x.getKey(), x.getValue()));
	        System.out.println("Result 4 Order by Value :: "+ result4);

	}

}
