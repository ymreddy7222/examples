/**
 * 
 */
package com.example;

/**
 * @author Madhav Reddy
 *
 */
public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		
		Addition addition = (a, b) -> {
			
			System.out.println("a + b : " + a + b);
			return a + b;
		};
		
		int result = addition.add(5, 10);
		System.out.println("Result : " + result);
	}
}
