package com.zy.observe.demo;

import java.util.Observable;
import java.util.Observer;

public class Athena implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("come on");
	}

}
