package com.zy.component;

public class MyException extends RuntimeException{

	private String error;
	
	public MyException() {
		
	}
	
	public  MyException(String massage) {
		super(massage);
	}
	
	public String getError() {
		return error;
	}

	
	
	public void setError(String error) {
		this.error = error;
	}

	
	
	public static MyException exception() {
		MyException e = new MyException();
		e.setError("抛出异常了");
		return e;
	}

}
