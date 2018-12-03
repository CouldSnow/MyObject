package com.zy.annotation;

import java.lang.reflect.Method;

public class AnnoTest {
   
	public static void main(String[] args) {
		/*boolean b =  AnnoTest.class.isAnnotationPresent(MyAnno2.class);
	    if(b) {
	    	MyAnno2 m2 = AnnoTest.class.getAnnotation(MyAnno2.class);
			String username=m2.username();
			System.out.println(username);
	    }*/
		
		try {
			Class clazz = AnnoDemo.class;
			Object obj = clazz.newInstance();
			
			Method[] allMethods = clazz.getMethods();
			
			for(Method m:allMethods) {
				
				if(m.isAnnotationPresent(myTest.class)) {
					m.invoke(obj, null);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
