package com.zy.observe;

import java.util.Observable;
import java.util.Observer;

public class Satellite  implements Observer{

	private String weather;
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Earth earth = (Earth)o;
		earth.setWeather("下雨了");
		weather = (String) arg;
		System.out.println("weather:"+weather);
	}

}
