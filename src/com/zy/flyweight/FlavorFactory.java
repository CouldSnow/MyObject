package com.zy.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
* @author 郑炎
* @version 创建时间：2018年9月13日 下午2:02:51
* @ClassName 类名称
* @Description 类描述
*/
public class FlavorFactory {

	private Map<String ,Oreder> flavorPool = new HashMap<>(20);
	
	private static FlavorFactory flavorFactory = new FlavorFactory();
	private FlavorFactory() {}
	//静态工厂，负责生成订单
	public static FlavorFactory getInstance() {
		return flavorFactory;
	}
	
	public Oreder getOreder(String flavor) {
		Oreder order = null;
		if(flavorPool.containsKey(flavor)) {
			order = flavorPool.get(flavor);
		}else {
			order = new FlavorOrder(flavor);
			flavorPool.put(flavor, order);
		}
		return order;
	}
	
	public int getTotlFlavorsMade() {
		return flavorPool.size();
	}
}
