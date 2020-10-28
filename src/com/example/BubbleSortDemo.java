/**
 * 
 */
package com.example;

import java.util.Arrays;

/**
 * @author Madhav Reddy
 *
 */
public class BubbleSortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {1,2, 4, 5, 2, 3, 1, 6, 3, 4};
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < n - 1; i++) {
			
			for (int j = 0; j < n - i - 1; j++) {
				
				if (arr[j] > arr[j+1]) {
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
