package com.sarat.java8.lamdaExpressions;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ListFiles {

	public static void main(String[] args) throws IOException {
		File currentDir = new File(".").getCanonicalFile();
		//displayDirectoryContentsImperativeStyle(currentDir);
		displayDirectoryContentsJava8Style(currentDir);
	}

	private static void displayDirectoryContentsJava8Style(File currentDir) {
		System.out.println(Stream.of(currentDir.listFiles())
								 .map(File::getName)
								 .map(String::toUpperCase)
								 .collect(joining(", ")));
		
	}

	private static void displayDirectoryContentsImperativeStyle(File currentDir) throws IOException {
		
		File[] childDirs = currentDir.listFiles();
		
		if(childDirs != null){
			for(File file : childDirs)
				if(file.isDirectory()){
					System.out.println("Directory  : "+ file.getCanonicalPath());
					displayDirectoryContentsImperativeStyle(file);
				}else
					System.out.println("	File  : " + file.getName());
		}
	}

}
