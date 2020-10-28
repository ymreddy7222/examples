/**
 * 
 */
package com.example;

import java.util.Scanner;

/**
 * @author Madhav Reddy
 *
 */
public class NthPrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Program to find Nth prime number");
		
		int num = 1, count = 0, i;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to find it's Nth prime number");
		int n = sc.nextInt();
		
		while (count < n) {
			
			num=num+1;
			for (i = 2; i <= num; i++) {
				
				if (num % i == 0) {
					
					break;
				}
			}
			
			if (i == num) {
				
				count = count + 1;
			}
		}
		
		System.out.println("Value of Nth prime number is : " + +num);
		sc.close();
	}

}
