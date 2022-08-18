/*package com.sarat.sorting;

import practice.sorting.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSortTest {
	
	
	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(2, "Sumit"));
		empList.add(new Employee(1, "Sarat"));
		empList.add(new Employee(3, "Sujit"));
		
		System.out.println(empList);
		
		//List<Employee> empList1 = Arrays.asList(new Employee(6, "sssss"), new Employee(4, "aaaaa"), new Employee(5, "dddd"));
		//System.out.println(Arrays.sort(empList1)); //this is because Arrays.asList is immutable.
		
		Employee[] empList2 = {new Employee(6, "sssss"), new Employee(4, "aaaaa"), new Employee(5, "dddd")};
			
		for(Employee e : empList2) {
			System.out.println(e);
		}
		
		Arrays.sort(empList2, Employee.empComparator);
		System.out.println();
		for(Employee e : empList2) {
			System.out.println(e);
		}
		
		//Collections.sort(empList, Employee.empComparator);
		
		empList.stream().sorted(Employee.empComparator)
						.collect(Collectors.toList())
						.forEach(System.out::println);
		
		
	}
}
*/