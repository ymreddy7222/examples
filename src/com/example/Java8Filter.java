/**
 * 
 */
package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Madhav Reddy
 *
 */

/*class Employee {

	private String name;
	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

}*/

public class Java8Filter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Employee> list = new ArrayList<Employee>();
		Employee employe1 = new Employee("Madhav", 28, 3300);
		Employee employe2 = new Employee("Shree", 24, 2300);
		Employee employe3 = new Employee("Jaipal", 27, 1300);
		Employee employe4 = new Employee("Shivu", 26, 5300);
		Employee employe5 = new Employee("Sai", 24, 6300);
		
		list.add(employe1);
		list.add(employe2);
		list.add(employe3);
		list.add(employe4);
		list.add(employe5);
		
		boolean allMatches = list.stream().allMatch(new Predicate<Employee>() {
			
			public boolean test(Employee e) {
				
				if (e.getName().contains("a")) 
					return true;
				return false;
			};
		});
		
		// Check whether given condition matches on all elements 
		System.out.println("allMatches : " + allMatches);
		allMatches = list.stream().allMatch(e -> e.getName().contains("a"));
		System.out.println("allMatches : " + allMatches);
		
		// Check whether given condition matches on any of the elements in list
		Boolean anyMatch = list.stream().anyMatch(e -> e.getName().contains("a"));
		System.out.println("anyMatch : " + anyMatch);
		
		// Filter Employee objects whos name starts with s
		
		List<Employee> filter = list.stream().filter(e -> e.getName().startsWith("S")).collect(Collectors.toList());
		filter.forEach(e -> System.out.println(e));
	//	filter.forEach(e -> System.out.println(e));
	//	list = new ArrayList<>();
		Employee first = list.stream().findFirst().orElse(null);
		System.out.println("First " + first);
		
		// Comparing list based on employee name asc
		
		List<Employee> sortedList = list.stream().sorted(new Comparator<Employee>() {
			
			public int compare(Employee o1, Employee o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		}).collect(Collectors.toList());
		
		System.out.println("********* Sorted List *********");
		sortedList.forEach(System.out:: println);
		System.out.println("********* Sorted List Sal*********");
		sortedList = list.stream().sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary())).collect(Collectors.toList());
		sortedList.forEach(System.out:: println);
		
		Collections.sort(list, new Comparator<Employee>() {
			
			public int compare(Employee o1, Employee o2) {
				
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});
		
		Collections.sort(list, (e1, e2) -> e2.getSalary().compareTo(e1.getSalary()));
		System.out.println(list);
		
		list.sort(Comparator.comparingInt(new ToIntFunction<Employee>() {
			
			public int applyAsInt(Employee e) {
				
				return e.getAge();
			}
		}));
		
		list.sort(Comparator.comparingInt(Employee :: getAge));
		
		// Summing salary of all employees
		
		Double sum = list.stream().collect(Collectors.summingDouble(Employee :: getSalary));
		System.out.println("Sum of Salaries : " + sum);
		
		Employee maxSalEmp = list.stream().max((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1).orElse(null);
		System.out.println("Employee with max salary : " + maxSalEmp);
		
		System.out.println("Total number of employees : " + list.stream().count());
		
		System.out.println("Total number of employees name starting with S : " + list.stream().filter(e -> e.getName().startsWith("S")).count());
		
		System.out.println("Checking name isMadhav?");
		Stream<Boolean> trueVal = list.stream().map(e -> e.getName().equalsIgnoreCase("Madhav"));
		trueVal.forEach(System.out::println);
		
		Set<Integer> collect = list.stream().map(e -> e.getAge()).collect(Collectors.toSet());
		System.out.println("Ages : " + collect);
		
		Map<String, Double> map = list.stream().collect(Collectors.toMap(Employee :: getName, Employee :: getSalary));
		System.out.println("Map : " + map);
		
		Integer reduce = list.stream().map(e -> e.getAge()).reduce(new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer e1, Integer e2) {
				
				return e1 + e2;
			}
		}).orElse(0);
		
		System.out.println("Reduce result : " + reduce);
		reduce = list.stream().map(e -> e.getAge()).reduce((age1, age2) -> add(age1, age2)).orElse(0);
		System.out.println("Reduce result : " + reduce);
		
		List<Integer> list2 = list.stream().map(e -> e.getAge() + 10).collect(Collectors.toList());

		list2.forEach(System.out :: println);
		
		list.parallelStream().forEach(System.out :: println);
	}

	public static Integer add(Integer age1, Integer age2) {
		
		System.out.println("Age 1 : " + age1 + ", Age 2 : " + age2);
		return age1 + age2;
	}
}
