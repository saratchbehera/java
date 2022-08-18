package com.sarat.test;

import java.io.*;
import java.util.function.Function;

public class AssetUtil {

	
	public static void main(String[] args) {
		
		
		startLinkAssets("");
	}
	
	private static void  startLinkAssets(final String filePath)
	{
		try{
		      File inputF = new File("C:\\app\\2.csv");
		      InputStream inputFS = new FileInputStream(inputF);
		      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
		      // skip the header of the csv
		      //inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
		      br.lines().map(new AssetUtil().mapToItem).forEach(System.out::println);
		      br.close();
		    } catch (IOException e) {
		    	System.out.println("Exception");
		    }
	}
	
	private Function<String,Boolean> mapToItem = (line) -> {
		System.out.println("inside Function");
		String[] p = line.split(",");
		System.out.println(p[0]);
		return null;
	};
	
	private boolean mapbyMethod(String line)
	{
		System.out.println("inside Function");
		
		String[] p = line.split(",");
		System.out.println(p[0]);
		return true;
	}
}