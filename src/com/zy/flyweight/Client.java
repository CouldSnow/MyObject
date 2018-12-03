package com.zy.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
* @author 郑炎
* @version 创建时间：2018年9月13日 下午2:10:04
* @ClassName 类名称
* @Description 类描述
*/
public class Client {

	private static List<Oreder> orders = new ArrayList<>();
	private static FlavorFactory flavorFactory;
	
	private static void taskOrders(String falvor) {
		orders.add(flavorFactory.getOreder(falvor));
	}
	public static void main(String[] args) {
		flavorFactory  = FlavorFactory.getInstance();
	}
}
