package com.zy.jdk;
/**
* @author 郑炎
* @version 创建时间：2018年9月26日 上午11:53:49
* @ClassName 类名称
* @Description 类描述
*/
public class Person implements Man{

	private String name;
	private int age;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
