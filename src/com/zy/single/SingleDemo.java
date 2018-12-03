package com.zy.single;

public class SingleDemo {

	private SingleDemo(){}
	
	private static class Single{
		private static SingleDemo singdemo= new SingleDemo();
	}
	
	
	public static synchronized SingleDemo getInstance() {  //多线程 安全
		return Single.singdemo;
	}
	
}
