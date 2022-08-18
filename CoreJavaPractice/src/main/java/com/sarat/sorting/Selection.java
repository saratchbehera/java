package com.sarat.sorting;

public class Selection {

	public static void main(String[] args) {
		int A[] = {2,7,4,1,5,3};
		doSelectionSort(A,6);
		
		System.out.print("Sorted Elements :");
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]);
		}
	}
	
	static void doSelectionSort(int A[], int n){
		
		//We need to do N-2 passes
		for(int i = 0; i<n-1; i++){
			
			//ith position : Elements from i till N-1 are candidates
			int iMin = i;											//c1 time 
			for(int j = i+1; j<n; j++){
				if(A[j] < A[iMin]){
					
					//Update the index of the minimum element
					iMin = j;
				}
				
			//Swap two elements 
			int temp = A[i];
			A[i] = A[iMin];
			A[iMin] = temp;
			}
		}
	}

}
