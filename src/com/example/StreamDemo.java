package com.example;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		/*
		 * // Consumer<Integer> consumer = i -> System.out.println("i : " + i);
		 * 
		 * // list.forEach(i -> System.out.println("i : " + i)); //
		 * list.forEach(consumer); // list.forEach(i -> System.out.println("i : " + i));
		 * // list.forEach(System.out :: println); // list.forEach(StreamDemo ::
		 * doubleIt);
		 * 
		 * Stream<Integer> stream = list.stream();
		 * 
		 * stream.forEach(System.out::println); // stream.forEach(System.out::println);
		 */
		list.stream().filter(i -> i > 0).sorted((i, j) -> j.compareTo(i)).forEach(System.out::println);

	}

	public static void doubleIt(int i) {

		System.out.println(i * 2);
	}

}
