/**
 * 
 */
package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Madhav Reddy
 *
 */

class Employee {

	private String name;
	private int age;
	private Double salary;

	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	
}

/*class EmployeeComparatorBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getSalary() > o2.getSalary();
	}
	
	
}*/

public class StreamWithCustomObjects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		Employee employe1 = new Employee("Madhav", 28, 3300);
		Employee employe2 = new Employee("Shree", 24, 2300);
		Employee employe3 = new Employee("Jaipal", 27, 1300);
		Employee employe4 = new Employee("Shivu", 26, 5300);
		Employee employe5 = new Employee("Sai", 24, 6300);
		
		employees.add(employe1);
		employees.add(employe2);
		employees.add(employe3);
		employees.add(employe4);
		employees.add(employe5);
		
		// Using java 8 stream API on Collections
		
		// Display all employees In ascending order(by salary)
		
		employees.sort(Comparator.comparingDouble(Employee :: getSalary));
		System.out.println(employees);
		
		// Displaying employees names starts with sh
		System.out.println("Displaying employees names starts with sh");
		employees.stream()
		.filter(e -> e.getName().startsWith("Sh")).forEach(System.out :: println);
		
		/*Function n = new Function<Employee, Double>() {

			@Override
			public Double apply(Employee t) {
				// TODO Auto-generated method stub
				return t.getSalary() + 2;
			}
			
		};*/
		
		System.out.println("Displaying sum of salary of all employees");
		System.out.println("Sum of Salary : " + employees.stream().collect(Collectors.summingDouble(Employee:: getSalary)));
		
	}

}
