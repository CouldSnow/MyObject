package com.zy.jdk;
/**
* @author 郑炎
* @version 创建时间：2018年9月26日 上午11:54:53
* @ClassName 类名称
* @Description 类描述
*/
public class PersonImpl {

	public static void personOne(Person person) {
		  System.out.println(person.getName());
	}
	
	public static void main(String[] args) {
		PersonImpl.personOne(new Person());
	}
}
