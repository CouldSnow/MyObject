package com.zy.component;

public class CompositeTest {

	public static void main(String[] args) {
		
		Composite root = new Composite("root");
		Composite com1 = new Composite("com1");
		Composite com2 = new Composite("com2");
		Composite com3 = new Composite("com3");
		
		Leaf leaf1 = new Leaf("leaf1");
		Leaf leaf2 = new Leaf("leaf2");
		com1.add(leaf1);
		com1.add(leaf2);
		com1.add(com3);
		com3.add(leaf2);
		root.add(com1);
		
		Leaf leaf3 = new Leaf("leaf3");
		Leaf leaf4= new Leaf("leaf4");
		com2.add(leaf3);
		com2.add(leaf4);
		root.add(com2);
		
	/*	Leaf leaf5 = new Leaf("leaf5");
		leaf4.add(leaf5);*/
		root.disPlay(1);
	}
}
