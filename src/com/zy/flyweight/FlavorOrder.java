package com.zy.flyweight;
/**
* @author 郑炎
* @version 创建时间：2018年9月13日 下午2:00:24
* @ClassName 类名称
* @Description 类描述
*/
public class FlavorOrder extends Oreder{

	private String flavor;
	
	public FlavorOrder(String flavor) {
		this.flavor = flavor;
	}
	@Override
	public void sell() {
		// TODO Auto-generated method stub
		System.out.println("卖出了一杯："+flavor);
	}

	@Override
	public String getFlavor() {
		// TODO Auto-generated method stub
		return this.flavor ;
	}

}
