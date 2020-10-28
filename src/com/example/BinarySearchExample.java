/**
 * 
 */
package com.example;

import java.util.Arrays;

/**
 * @author Madhav Reddy
 *
 */

public class BinarySearchExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 10, 23, 45, 20, 38, 13};
		System.out.println("Input array : " + Arrays.toString(arr));
		
		int result = binarySearch(arr, 38);
		System.out.println("Result : " + result);
		result = Arrays.binarySearch(arr, 38);
		System.out.println("Result : " + result);
		
	}

	public static int binarySearch(int[] arr, int elementToSearch) {
		
		Arrays.sort(arr);
		System.out.println("Sorted array : " + Arrays.toString(arr));
		
		int firstIndex = 0;
		int lastIndex = arr.length - 1;
		System.out.println("First Index : " + firstIndex);
		System.out.println("Last Index : " + lastIndex);
		
		while(firstIndex <= lastIndex) {
			
			int middleIndex = firstIndex + lastIndex / 2;
			System.out.println("Middle Index : " + middleIndex);
			
			if (arr[middleIndex] == elementToSearch) {
				
				return middleIndex;
			} else if (arr[middleIndex] > elementToSearch) {
				
				firstIndex = middleIndex + 1;
			} else if (arr[middleIndex] < elementToSearch) {
				
				lastIndex = middleIndex - 1;
			}
			System.out.println("First Index : " + firstIndex);
			System.out.println("Last Index : " + lastIndex);
		}
		
		return -1;
	}
}
