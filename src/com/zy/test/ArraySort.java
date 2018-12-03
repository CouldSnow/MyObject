package com.zy.test;
/**
* @author 郑炎
* @version 创建时间：2018年11月20日 下午1:21:24
* @ClassName 类名称
* @Description 类描述
*/
public class ArraySort {

	private int num;
	
	  public ArraySort(int num) {
		  this.num = num;
	  }
	  
	  public static void main(String[] args) {
		  int[] numbers = {22,12,31,19,422};
		  for(int number: numbers) {
			  new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(number);
						System.out.println(number);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		  }
	  }
}
