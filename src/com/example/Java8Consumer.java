/**
 * 
 */
package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Madhav Reddy
 *
 */
public class Java8Consumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		list.forEach(new Consumer<Integer>() {
			
			public void accept(Integer t) {
				
				t = t+1;
				System.out.println(t);
			};
		});
		
		list.forEach(ConsumerDemo :: apply);
		list.forEach(i -> System.out.println(i));
	}

}
class ConsumerDemo {
	
	public static int apply(Integer i) {
		
		i = i*2;
		System.out.println("i value after apply : " + i);
		return i;
	}
}
