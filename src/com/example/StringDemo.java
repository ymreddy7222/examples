/**
 * 
 */
package com.example;

import java.util.Scanner;

/**
 * @author Madhav Reddy
 *
 */
public class StringDemo {

	public static void main(String[] args) {
		
		System.out.println("String first letter uppercase demo");
		System.out.println("Please enter a sentence ");
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		
		System.out.println("Input : " + inputStr);
		String strArr[] = inputStr.trim().split(" ");
		String resultStr = "";
		for (int i = 0; i < strArr.length; i++) {
			
			String firstLetter = strArr[i].substring(0, 1);
			String wordExceptFirstLetter = strArr[i].substring(1);
			
			resultStr = resultStr + firstLetter.toUpperCase() + wordExceptFirstLetter + " ";
		}
		sc.close();
		System.out.println("Output : " + resultStr);
		printPermutation("ab", "");
	}
	
	public static void printPermutation(String str, String emptyStr) {
		
		if (str.length() == 0) {
			
			System.out.println(emptyStr + "");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
		//	System.out.println("ch : " + ch);
			
			String permute = str.substring(0, i) + str.substring(i + 1);
//			System.out.println("Permute : " + permute);
			
			printPermutation(permute, emptyStr + ch);
		}
	}
}