package com.sarat.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("continent|**|country|**|state".split("\\|\\*\\*\\|"));
		System.out.println(list.stream()
								.skip((list.size()>1)?1:0)
								.sorted(Collections.reverseOrder())
								.collect(Collectors.joining(","))
        				);
	}

}
