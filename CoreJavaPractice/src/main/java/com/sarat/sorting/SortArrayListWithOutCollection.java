package com.sarat.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortArrayListWithOutCollection {

	public static void main(String[] args) {
		
		List<Integer> arrList = new ArrayList<Integer>();
		
		arrList.add(4);
		arrList.add(5);
		arrList.add(9);
		arrList.add(1);
		arrList.add(14);
		arrList.add(12);
		arrList.add(50);
		arrList.add(9);
		
		doSort(arrList);
		System.out.println("Sorted ArrayList  : "+ arrList);
		
	}


	
	public static void swap(List<Integer> arrList, int i, int j) {
	    int tmp = arrList.get(i);
	    arrList.set(i, arrList.get(j));
	    arrList.set(j, tmp);
	}

	public static void doSort(List<Integer> arrList) {
	    int min;
	    for (int i = 0; i < arrList.size(); ++i) {
	        //find minimum in the rest of array
	        min = i;
	        for (int j = i + 1; j < arrList.size(); ++j) {
	            if (arrList.get(j) < arrList.get(min)) {
	                min = j;
	            }
	        }

	        //do swap
	        swap(arrList, i, min);
	    }
	}


}

