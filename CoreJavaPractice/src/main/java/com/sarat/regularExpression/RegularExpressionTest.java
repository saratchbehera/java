package com.sarat.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static final String data = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ" + 
			"0123456789 _+-.,!@#$%^&*();\\/|<>\"'\r\n" + 
			"12345 -98.7 3.141 .6180 9,000 +42\r\n" + 
			"555.123.4567	+1-(800)-555-2468\r\n" + 
			"foo@demo.net	bar.ba@test.co.uk\r\n" + 
			"www.demo.com	http://foo.co.uk/";
	
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(data);
		if(matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
