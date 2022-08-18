package com.sarat.io;

import java.io.File;

public class TestFileName {

	public static void main(String[] args) {
		File indexTXT = new File("C:\\Users\\u6039740\\Desktop\\new.crtxt");
		if(!indexTXT.getName().endsWith(".crtxt")) {
			System.out.println("txt");
			System.out.println(indexTXT.getName());
		}
		else
			System.out.println("crtxt");
	}
}
