package com.sarat.designPatterns.creational_Design_Patterns.singleton;


public class Hello {

	public static void main(String[] args) {

		String str0 = "SELECT * FROM ";
		String str1 = "EMPLOYEE";
		StringBuffer strbffr = new StringBuffer();
		strbffr.append(str0);
		strbffr.append(str1);
		System.out.println(strbffr);
		
		
		String str2 = "bikash";
		String str3 = "behera";
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append(str2);
		strbuilder.append(str3);
		System.out.println(strbuilder);
		
		
		/*
		
		 * ArrayList arr = new ArrayList(); arr.add(0); arr.add(1); arr.add(3);
		 * arr.add(null);
		 * 
		 * Set se = new HashSet(); se.add("a"); se.add(0); se.add("c");
		 * se.add("b"); se.add(null); se.add(0);
		 * //System.out.println("SET-->"+se);
		 * 
		 * Map me = new HashMap();
		 * 
		 * me.put(0, "a"); me.put(1, "b"); me.put(2, "c"); me.put(null,
		 * "key - null"); me.put(null, "key -2nd  null"); me.put(4, null);
		 * me.put(0, "Z"); // System.out.println("HashMap-->"+me);
		 * 
		 * 
		 * System.out.println(); Iterator it = arr.iterator();
		 * while(it.hasNext()){
		 * 
		 * System.out.print(it.next()); } System.out.println(); it =
		 * se.iterator(); while(it.hasNext()){
		 * 
		 * System.out.print(it.next()); }
		 * 
		 * 
		 * Iterator iterator = me.keySet().iterator();
		 * while(iterator.hasNext()){ String val = (String)
		 * me.get(iterator.next());
		 * System.out.println("Iterator : Hashmap  :  "+val); }
		 * 
		 * Iterator ite = me.entrySet().iterator(); while (ite.hasNext()) {
		 * Map.Entry entry = (Map.Entry) ite.next(); Integer key =
		 * (Integer)entry.getKey(); String val = (String)entry.getValue();
		 * System.out.println("key,val: " + key + "," + val); }
		 * 
		 * Map mp = new Hashtable();
		 * 
		 * mp.put(0, "s"); mp.put(1, "a"); mp.put(2, "r"); mp.put(3, "a");
		 * mp.put(4, "t");
		 * 
		 * System.out.println("HashTable");
		 * 
		 * Iterator itr = mp.keySet().iterator(); while(itr.hasNext()){ String
		 * val = (String) mp.get(itr.next());
		 * System.out.println("Iterator : Hashtable  :  "+val); }
		 */

		// System.out.println(arr);
		// TODO Auto-generated method stub

	}
	
	
	

}
