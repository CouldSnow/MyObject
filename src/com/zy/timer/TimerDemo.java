package com.zy.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
			    System.out.println("1111");	
			}
		}, 5*1000);
	}
}
