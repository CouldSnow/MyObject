package com.zy.reflect;

import java.lang.reflect.Constructor;


public class reflectTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Class.forName("com.zy.reflect.Student");
		
		//Constructor[] cons = clazz.getConstructors();
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor c : cons) {
			System.out.println(c);
		}
	}
}
