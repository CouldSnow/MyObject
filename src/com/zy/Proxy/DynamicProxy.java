package com.zy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

	private Object subject;
	
	public DynamicProxy(Object subject) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before rent house");
		System.out.println("Method:"+method);
		
		method.invoke(subject, args);
		
		return null;
	}

}
