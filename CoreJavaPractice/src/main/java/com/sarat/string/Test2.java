package com.sarat.string;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {
		final Map<String, List<Employee2>> empMaps = Maps.newHashMap();
		empMaps.put("CSE", Collections.singletonList(new Employee2("1", "Sandeep")));
		empMaps.put("ECE", Collections.singletonList(new Employee2("2", "Mandeep")));
		empMaps.put("ISE", Collections.singletonList(new Employee2("3", "Pradeep")));

		Stream stream = empMaps.values().stream()
				.flatMap(e -> { 
					return e.stream().map(m ->
					new EmpNames(((Employee2) e).getName()));							
				});
		
		
		
		List<EmpNames> lists = empMaps.values().stream()
									.flatMap(e -> { 
										return e.stream().map(m -> new EmpNames(m.getName()));							
									}).collect(Collectors.toList());									
									;
		System.out.println(lists);
	}

}
