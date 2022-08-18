package com.sarat.exception;

public class TestRuntimeException {

	public static void main(String[] args) throws Exception{
		
		int x = checkReturnForFinally();
		System.out.println(x);
	}
	
	public static int checkReturnForFinally(){
		try{
			int a = 10/0;
		}catch(NullPointerException r){
			System.out.println("NullPointerEx RE");
		}catch(Exception e){
			System.out.println("Exception  :"+e);
			return -1;
		}finally{
			System.out.println("finally");
		}
		return 0;
	}

}
