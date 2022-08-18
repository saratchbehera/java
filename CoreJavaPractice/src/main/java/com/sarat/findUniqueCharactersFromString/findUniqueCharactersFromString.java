package com.sarat.findUniqueCharactersFromString;

import java.util.HashMap;

public class findUniqueCharactersFromString {
	
	static int count;
	
	public static void main(String[] args) {
		String s = "teeter";
		HashMap<Character, Integer> hashmap= new HashMap<Character, Integer>();
		Character c;
		for(int i=0; i<s.length(); i++){
			c=s.charAt(i);
			if(hashmap.containsKey(c)){
				hashmap.put(c, count+1);
			}
			else{				
				hashmap.put(c, count);
			}
		}
		System.out.println(hashmap);
		
		for(Character ch : hashmap.keySet()){
			if(hashmap.get(ch) == 0){
				System.out.println("unique elements : "+ch);
			}
		}
		
	}
}
