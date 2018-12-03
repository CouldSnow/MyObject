package com.zy.jsoup.test;
/**
* @author 郑炎
* @version 创建时间：2018年11月24日 上午9:10:34
* @ClassName 类名称
* @Description 类描述
*/
public class MyGirl {
    
    private String name = "yyl";
	
    private static class MyOnlyGirl{
    	private final static MyGirl myGirl = new MyGirl();
    }
    
    private MyGirl() {
    }
    
    public  static  MyGirl youAreMyOnly() {
    	return MyOnlyGirl.myGirl;
    }
	
	public void doMarry() {
           System.out.println("marryMe");		
	}

	public static void main(String[] args) {
    	MyGirl myGirl = MyGirl.youAreMyOnly();
    	myGirl.doMarry();
    }
}
